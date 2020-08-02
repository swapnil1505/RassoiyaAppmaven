package com.rasoiyya.service.admin.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rasoiyya.domain.Address;
import com.rasoiyya.domain.Admin;
import com.rasoiyya.domain.City;
import com.rasoiyya.domain.Person;
import com.rasoiyya.domain.State;
import com.rasoiyya.domain.UserAddress;
import com.rasoiyya.domain.UserLogin;
import com.rasoiyya.dto.common.AddressRequest;
import com.rasoiyya.dto.common.AddressResponse;
import com.rasoiyya.dto.admin.AdminProfileResponse;
import com.rasoiyya.dto.admin.AdminRegistrationRequest;
import com.rasoiyya.dto.admin.AdminUpdateProfileRequest;
import com.rasoiyya.dto.admin.ViewAdminProfileRequest;
import com.rasoiyya.repository.common.AddressRepository;
import com.rasoiyya.repository.common.PersonRepository;
import com.rasoiyya.repository.common.UserAddressRepository;
import com.rasoiyya.repository.common.UserLoginRepository;
import com.rasoiyya.repository.admin.AdminRepository;
import com.rasoiyya.service.admin.AdminProfileService;
import com.rasoiyya.util.GlobalConstants;
import com.rasoiyya.util.StringUtils;

@Service
public class AdminProfileServiceImpl implements AdminProfileService {
	
	@Autowired
	UserLoginRepository userLoginRepository;
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	UserAddressRepository userAddressRepository;
	
	Logger log = LoggerFactory.getLogger(AdminProfileServiceImpl.class);
	
	@Transactional
	@Override
	public AdminProfileResponse viewProfile(ViewAdminProfileRequest viewAdminProfileRequest) {
		String userName = 	viewAdminProfileRequest.getUser_name();	
		AdminProfileResponse response = new AdminProfileResponse();
		try {
			if (StringUtils.isNotEmptyStr(userName)) {
				UserLogin userLogin = userLoginRepository.findByUsername(userName);
				if (userLogin != null ) {
					response.setUser_id(Integer.toString(userLogin.getUserId()));
					response.setUser_name(userLogin.getUsername());
					List<Person> persons =  personRepository.findByUserLoginId (userLogin.getUserId());
					if (persons != null && persons.size() > 0 ) {
						Person person = persons.get(0);
						Admin admin = null;
						List <Admin> admins = adminRepository.findByPersonId(person.getPersonId());
						if (admins != null && admins.size() > 0)
							admin = admins.get(0);
						
						prepareResponseObject(response, person, userLogin, admin);
						
						/*response.setDate_of_birth(person.getDateOfBirth());
						response.setEmail_id(person.getEmail());
						response.setFirst_name(person.getFirstname());
						response.setGender(person.getGender());
						response.setGovt_id_no(person.getGovtIdNo());
						response.setGovt_id_type(person.getGovtIdType());
						response.setLast_name(person.getLastname());
						response.setMobile_number(person.getMobileNo());
						response.setModified_by(person.getModifiedBy());
						response.setCreated_by(person.getCreatedBy());
						response.setCreated_date(StringUtils.dateToString(person.getCreatedDate()));
						response.setModified_date(StringUtils.dateToString(person.getLastUpdatedDate()));
						
						List <Admin> admins = adminRepository.findByPersonId(person.getPersonId());
						if (admins != null && admins.size() > 0) {
							Admin admin = admins.get(0);
							response.setIs_kyc_verified(admin.getIsKycVerified());
							response.setAdmin_status(admin.getStatus());
							response.setAdmin_id(Integer.toString(admin.getAdminId()));
						}*/
					}
					
					List <UserAddress> userAddressList =  userAddressRepository.findAddressByuserId(userLogin.getUserId());
					List <AddressResponse> addressListRes = new ArrayList<AddressResponse>();
					if (userAddressList != null && userAddressList.size() > 0) {
						userAddressList.forEach(userAddress -> {
							Integer addressId = userAddress.getAddressId();
							String isCurrentAddress = userAddress.getIsCurrentAddress();
							List <Address> addressList = addressRepository.findAddressById(addressId);						
							if (addressList != null && addressList.size() >0 ) {
								Address address = addressList.get(0);						
								AddressResponse addressRes = new AddressResponse();
								prepareAddressResponseObject(addressRes, address);
								addressRes.setIs_current_address(isCurrentAddress);
								addressListRes.add(addressRes);
							}
						});
					}
					
					if (addressListRes.size() > 0) {
						response.setAddressList(addressListRes);
					}
	
					log.error("Admin view Profile  Sucess !! ");
					response.setStatus(GlobalConstants.SUCCESS);
					response.setStatus_code(GlobalConstants.SUCCESS_CODE);
					response.setStatus_message(GlobalConstants.VIEW_PROFILE_SUCESSFULL);
									
				} else {
					log.error("Admin view Profile  Failed - Invalid User Name  !! ");
					response.setStatus(GlobalConstants.ERROR);
					response.setStatus_code(GlobalConstants.ERROR_CODE);
					response.setStatus_message(GlobalConstants.INVALID_USER);
					return response;
				}
			} 
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}			
		return response;
	}

	@Transactional
	@Override
	public AdminProfileResponse updateProfile(AdminUpdateProfileRequest adminUpdateProfileRequest) {
		AdminProfileResponse adminProfileResponse = new AdminProfileResponse();	
		Integer adminId = adminUpdateProfileRequest.getAdminId();
		
		try {
			Optional<Admin> optionalAdmin = null;
			if(adminId != null ) {
				optionalAdmin = adminRepository.findById(adminId);
				Admin admin = optionalAdmin.get();
				
				if(StringUtils.isNotEmptyStr(adminUpdateProfileRequest.getIs_kyc_verified()))
					admin.setIsKycVerified(adminUpdateProfileRequest.getIs_kyc_verified());
				
				Person person = admin.getPerson();
				UserLogin userLogin = null;
				
				if(person !=null) {
					userLogin = person.getUserLogin();
					person.setDateOfBirth(adminUpdateProfileRequest.getDate_of_birth());
					person.setEmail(adminUpdateProfileRequest.getEmail_id());
					person.setFirstname(adminUpdateProfileRequest.getFirst_name());
					person.setGender(adminUpdateProfileRequest.getGender());
					person.setGovtIdNo(adminUpdateProfileRequest.getGovt_id_no());
					person.setGovtIdType(adminUpdateProfileRequest.getGovt_id_type());
					person.setLastname(adminUpdateProfileRequest.getLast_name());
					person.setMobileNo(adminUpdateProfileRequest.getMobile_number());
					person.setModifiedBy(GlobalConstants.SUPER_ADMIN);
					person.setLastUpdatedDate(new Date());
				}
				
				prepareResponseObject(adminProfileResponse, person, userLogin, admin);
				adminProfileResponse.setUser_name(userLogin.getUsername());
				adminProfileResponse.setUser_id(new Integer(userLogin.getUserId()).toString());
				
				if (adminUpdateProfileRequest.getAddressList() != null && adminUpdateProfileRequest.getAddressList().size() > 0) {
					List <AddressResponse> addressListRes = new ArrayList<AddressResponse>();
					for (AddressRequest addressRequest : adminUpdateProfileRequest.getAddressList()) {
						if(StringUtils.isNotEmptyStr(addressRequest.getAddress_id()) ) {
							Optional<Address> optionalAddress = addressRepository.findById(Integer.valueOf(addressRequest.getAddress_id()));
							Address address = optionalAddress.get();
							AddressResponse addressResponse = new AddressResponse();
							
							address.setAddressLine1(addressRequest.getAddress_line1());
							address.setAddressLine2(addressRequest.getAddress_line2());
							address.setAddressType(addressRequest.getAddress_type());
							address.setGeoLocation(addressRequest.getGeo_location());
							address.setDistrict(addressRequest.getDistrict());
							address.setPincode(addressRequest.getPin_code());
							
							if (StringUtils.isNotEmptyStr(addressRequest.getCity())) {
								City city = new City();
								city.setCityId(Integer.valueOf(addressRequest.getCity()));
								address.setCity(city);
							}
							if (StringUtils.isNotEmptyStr(addressRequest.getState())) {
								State state = new State();
								state.setStateId(Integer.valueOf(addressRequest.getState()));
								address.setState(state);
							}
							if (StringUtils.isNotEmptyStr(adminUpdateProfileRequest.getCreated_by())) {
								address.setModifiedBy(adminUpdateProfileRequest.getCreated_by());
							} else {
								address.setModifiedBy(GlobalConstants.SUPER_ADMIN);
							}
							prepareAddressResponseObject(addressResponse, address);
							if(StringUtils.isNotEmptyStr(addressRequest.getUserAddressId()) ) {
								Optional<UserAddress> optionalUserAddress = userAddressRepository.findById(Integer.valueOf(addressRequest.getUserAddressId()));
								UserAddress userAddress = optionalUserAddress.get();
								userAddress.setIsCurrentAddress(addressRequest.getIs_current_address());
								addressResponse.setIs_current_address(userAddress.getIsCurrentAddress());
							}
							addressListRes.add(addressResponse);
						}else {
							Address address = getAddressObject(addressRequest);
							AddressResponse addressResponse = new AddressResponse();
							// Save the Address
							address = addressRepository.save(address);
							
							prepareAddressResponseObject(addressResponse, address);
							
							UserAddress userAddress = new UserAddress();
							userAddress.setAddressId(address.getAddressId());
							userAddress.setUserLoginId(userLogin.getUserId());
							userAddress.setIsCurrentAddress(addressRequest.getIs_current_address());
							userAddress.setModifiedBy(GlobalConstants.SUPER_ADMIN);
							userAddress.setCreatedBy(GlobalConstants.SUPER_ADMIN);
							if (StringUtils.isNotEmptyStr(adminUpdateProfileRequest.getCreated_by())) { 
								userAddress.setModifiedBy(adminUpdateProfileRequest.getCreated_by());
								userAddress.setCreatedBy(adminUpdateProfileRequest.getCreated_by());
							}
							userAddress.setCreatedDate(new Date());
							userAddress.setModifiedDate(new Date());
							
							// Save User - Address Mapping Data
							userAddress = userAddressRepository.save(userAddress);
							addressResponse.setIs_current_address(userAddress.getIsCurrentAddress());
							addressListRes.add(addressResponse);
							
						}
					}
					if (addressListRes.size() > 0) {
						adminProfileResponse.setAddressList(addressListRes);
					}
	
					log.error("Admin Profile Update Suucess !! ");
					adminProfileResponse.setStatus(GlobalConstants.SUCCESS);
					adminProfileResponse.setStatus_code(GlobalConstants.SUCCESS_CODE);
					adminProfileResponse.setStatus_message(GlobalConstants.UPDATE_PROFILE_SUCESSFULL);
				}
			}else {
				log.error("Admin Profile Update Failed - Admin Id is Not Valid  !! ");
				adminProfileResponse.setStatus(GlobalConstants.ERROR);
				adminProfileResponse.setStatus_code(GlobalConstants.ERROR_CODE);
				adminProfileResponse.setStatus_message(GlobalConstants.INVALID_USER);
				return adminProfileResponse;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return adminProfileResponse;
	}

	private Address getAddressObject(AddressRequest addressRequest) {
		Address address = new Address();
		address.setAddressLine1(addressRequest.getAddress_line1());
		address.setAddressLine2(addressRequest.getAddress_line2());
		address.setAddressType(addressRequest.getAddress_type());
		if (StringUtils.isNotEmptyStr(addressRequest.getCity())) {
			City city = new City();
			city.setCityId(Integer.valueOf(addressRequest.getCity()));
			address.setCity(city);
		}
		
		if (StringUtils.isNotEmptyStr(addressRequest.getState())) {
			State state = new State();
			state.setStateId(Integer.valueOf(addressRequest.getState()));
			address.setState(state);
		}
		
		address.setCreatedBy(GlobalConstants.SUPER_ADMIN);
		address.setModifiedBy(GlobalConstants.SUPER_ADMIN);
		
		address.setCreatedDate(new Date());
		address.setDistrict(addressRequest.getDistrict());
		address.setGeoLocation(addressRequest.getGeo_location());
		address.setLastUpdatedDate(new Date());				
		address.setPincode(addressRequest.getPin_code());
		
		return address;
	}

	private void prepareResponseObject(AdminProfileResponse response,Person person, UserLogin userLogin, Admin admin) {
		response.setUser_id(Integer.toString(userLogin.getUserId()));
		response.setUser_name(userLogin.getUsername());
		if (person != null) {
			response.setPersonId(person.getPersonId());
			response.setDate_of_birth(person.getDateOfBirth());
			response.setEmail_id(person.getEmail());
			response.setFirst_name(person.getFirstname());
			response.setGender(person.getGender());
			response.setGovt_id_no(person.getGovtIdNo());
			response.setGovt_id_type(person.getGovtIdType());
			response.setLast_name(person.getLastname());
			response.setMobile_number(person.getMobileNo());
			response.setModified_by(person.getModifiedBy());
			response.setCreated_by(person.getCreatedBy());
			response.setCreated_date(StringUtils.dateToString(person.getCreatedDate()));
			response.setModified_date(StringUtils.dateToString(person.getLastUpdatedDate()));
			
			response.setIs_kyc_verified(admin.getIsKycVerified());
			response.setAdmin_status(admin.getStatus());
			response.setAdmin_id(Integer.toString(admin.getAdminId()));
		}		
	}
	
	private void prepareAddressResponseObject(AddressResponse addressRes, Address address) {
		addressRes.setAddress_id(Integer.toString(address.getAddressId()));
		addressRes.setAddress_line1(address.getAddressLine1());
		addressRes.setAddress_line2(address.getAddressLine2());
		addressRes.setAddress_type(address.getAddressType());
		addressRes.setCity(Integer.toString(address.getCity().getCityId()));
		addressRes.setCreated_date(StringUtils.dateToString(address.getCreatedDate()));
		addressRes.setModified_date(StringUtils.dateToString(address.getLastUpdatedDate()));
		addressRes.setCreated_by(address.getCreatedBy());
		addressRes.setModified_by(address.getModifiedBy());
		addressRes.setDistrict(address.getDistrict());
		addressRes.setGeo_location(address.getGeoLocation());
		addressRes.setState(Integer.toString(address.getState().getStateId()));
		addressRes.setPin_code(address.getPincode());
	}
}
