package com.rasoiyya.service.admin.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rasoiyya.domain.Address;
import com.rasoiyya.domain.Admin;
import com.rasoiyya.domain.Person;
import com.rasoiyya.domain.UserAddress;
import com.rasoiyya.domain.UserLogin;
import com.rasoiyya.dto.common.AddressResponse;
import com.rasoiyya.dto.admin.ViewAdminProfileRequest;
import com.rasoiyya.dto.admin.ViewAdminProfileResponse;
import com.rasoiyya.repository.common.AddressRepository;
import com.rasoiyya.repository.common.PersonRepository;
import com.rasoiyya.repository.common.UserAddressRepository;
import com.rasoiyya.repository.common.UserLoginRepository;
import com.rasoiyya.repository.admin.AdminRepository;
import com.rasoiyya.service.admin.AdminViewProfileService;
import com.rasoiyya.util.GlobalConstants;
import com.rasoiyya.util.StringUtils;

@Service
public class AdminViewProfileServiceImpl implements AdminViewProfileService {
	
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
	
	Logger log = LoggerFactory.getLogger(AdminViewProfileServiceImpl.class);
	
	@Transactional
	@Override
	public ViewAdminProfileResponse viewProfile(ViewAdminProfileRequest viewAdminProfileRequest) {
		String userName = 	viewAdminProfileRequest.getUser_name();	
		ViewAdminProfileResponse response = new ViewAdminProfileResponse();
		try {
			if (StringUtils.isNotEmptyStr(userName)) {
				UserLogin userLogin = userLoginRepository.findByUsername(userName);
				if (userLogin != null ) {
					response.setUser_id(Integer.toString(userLogin.getUserId()));
					response.setUser_name(userLogin.getUsername());
					List<Person> persons =  personRepository.findByUserLoginId (userLogin.getUserId());
					if (persons != null && persons.size() > 0 ) {
						Person person = persons.get(0);
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
						
						List <Admin> admins = adminRepository.findByPersonId(person.getPersonId());
						if (admins != null && admins.size() > 0) {
							Admin admin = admins.get(0);
							response.setIs_kyc_verified(admin.getIsKycVerified());
							response.setAdmin_status(admin.getStatus());
							response.setAdmin_id(Integer.toString(admin.getAdminId()));
						}
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

}
