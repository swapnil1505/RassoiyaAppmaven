package com.rasoiyya.service.admin.impl;

import java.util.Base64;
import java.util.Date;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rasoiyya.domain.Address;
import com.rasoiyya.domain.Admin;
import com.rasoiyya.domain.City;
import com.rasoiyya.domain.Person;
import com.rasoiyya.domain.RasoiyyaApiLogs;
import com.rasoiyya.domain.Role;
import com.rasoiyya.domain.State;
import com.rasoiyya.domain.UserAddress;
import com.rasoiyya.domain.UserLogin;
import com.rasoiyya.dto.admin.AdminRegistrationRequest;
import com.rasoiyya.dto.common.AddressRequest;
import com.rasoiyya.dto.common.RasoiyyaApiLogsDto;
import com.rasoiyya.repository.AddressRepository;
import com.rasoiyya.repository.PersonRepository;
import com.rasoiyya.repository.RasoiyyaApiLogsRepositoy;
import com.rasoiyya.repository.UserAddressRepository;
import com.rasoiyya.repository.UserLoginRepository;
import com.rasoiyya.repository.admin.AdminRepository;
import com.rasoiyya.service.admin.AdminRegistrationService;
import com.rasoiyya.util.GlobalConstants;
import com.rasoiyya.util.StringUtils;

@Service
public class AdminRegistrationServiceImpl implements AdminRegistrationService {
	
	@Autowired
	UserLoginRepository userLoginRepository;
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	UserAddressRepository userAddressRepository;
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	RasoiyyaApiLogsRepositoy rasoiyyaApiLogsRepositoy;
	
	Logger log = LoggerFactory.getLogger(AdminRegistrationServiceImpl.class);
	
	@Override
	@Transactional
	public void getAdminRegistration(AdminRegistrationRequest adminRegistrationRequest) throws Exception{
		try {
			UserLogin userLogin = getUserLogin(adminRegistrationRequest);
			// Save UserLogin
			userLogin = userLoginRepository.save(userLogin);
			log.info("User Login Data Save Successfully");			
			Person person = getPerson(adminRegistrationRequest);
			person.setUserLogin(userLogin);			
			person = personRepository.save(person);
			log.info("Person Data Save Successfully");
			
			if (adminRegistrationRequest.getAddressList() != null && adminRegistrationRequest.getAddressList().size() > 0) {
				for (AddressRequest addressRequest : adminRegistrationRequest.getAddressList()) {
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
					
					address.setCreatedBy(adminRegistrationRequest.getUser_name());
					address.setCreatedDate(new Date());
					address.setDistrict(addressRequest.getDistrict());
					address.setGeoLocation(addressRequest.getGeo_location());
					address.setLastUpdatedDate(new Date());
					address.setModifiedBy(adminRegistrationRequest.getUser_name());
					address.setPincode(addressRequest.getPin_code());
					
					// Save the Address
					address = addressRepository.save(address);
					
					UserAddress userAddress = new UserAddress();
					userAddress.setAddressId(address.getAddressId());
					userAddress.setUserLoginId(userLogin.getUserId());
					userAddress.setIsCurrentAddress(addressRequest.getIs_current_address());
					userAddress.setModifiedBy(userLogin.getUsername());
					userAddress.setCreatedBy(userLogin.getUsername());
					userAddress.setCreatedDate(new Date());
					userAddress.setModifiedDate(new Date());
					
					// Save User - Address Mapping Data
					userAddressRepository.save(userAddress);					
				}
			}
			
			Admin admin = new Admin();
			admin.setPerson(person);
			admin.setCreatedBy(GlobalConstants.SUPER_ADMIN);
			admin.setModifiedBy(userLogin.getUsername());
			admin.setCreatedDate(new Date());
			admin.setLastUpdatedDate(new Date());
			admin.setIsKycVerified(adminRegistrationRequest.getIs_kyc_verified());
			
			//Saving the Admin Data
			adminRepository.save(admin);
			
			log.info("Admin Registration SuccessFully in Service !!!!");
			
		} catch (Exception e) {
			log.info("User Login Failed !!!");
			e.printStackTrace();
			throw e;
		}
		
	}

	private Person getPerson(AdminRegistrationRequest adminRegistrationRequest) {
		Person person = new Person();
		person.setFirstname(adminRegistrationRequest.getFirst_name());
		person.setLastname(adminRegistrationRequest.getLast_name());
		person.setCreatedBy(GlobalConstants.SUPER_ADMIN);
		person.setCreatedDate(new Date());
		person.setEmail(adminRegistrationRequest.getEmail_id());
		person.setGovtIdNo(adminRegistrationRequest.getGovt_id_no());
		person.setGovtIdType(adminRegistrationRequest.getGovt_id_type());
		person.setLastUpdatedDate(new Date());
		person.setMobileNo(adminRegistrationRequest.getMobile_number());
		person.setModifiedBy(adminRegistrationRequest.getUser_name());
		
		return person;
	}

	private UserLogin getUserLogin(AdminRegistrationRequest adminRegistrationRequest) {
		UserLogin userLogin = new UserLogin();
		userLogin.setUsername(adminRegistrationRequest.getUser_name());
		String encodedPassword = Base64.getEncoder().encodeToString(adminRegistrationRequest.getPassword().getBytes());
		userLogin.setPassword(encodedPassword);
		userLogin.setCreatedBy(GlobalConstants.SUPER_ADMIN);
		userLogin.setCreatedDate(new Date());
		userLogin.setIsActive(true);
		userLogin.setIsParent("N");
		userLogin.setModifiedBy(adminRegistrationRequest.getUser_name());
		userLogin.setLastUpdatedDate(new Date());
		Role role = new Role();
		role.setRoleId(1);
		userLogin.setRoles(role);
				
		return userLogin;
	}

	@Override
	public RasoiyyaApiLogs saveApiLogs(RasoiyyaApiLogsDto rasoiyyaApiLogsDto) {
		RasoiyyaApiLogs rasoiyyaApiLogs = new RasoiyyaApiLogs();
		rasoiyyaApiLogs.setCreatedBy(rasoiyyaApiLogsDto.getCreatedBy());
		rasoiyyaApiLogs.setModifiedBy(rasoiyyaApiLogsDto.getModifiedBy());
		rasoiyyaApiLogs.setServiceName(rasoiyyaApiLogsDto.getServiceName());
		rasoiyyaApiLogs.setRequestuid(rasoiyyaApiLogsDto.getRequestuid());
		rasoiyyaApiLogs.setRequestTime(rasoiyyaApiLogsDto.getRequestTime());
		rasoiyyaApiLogs.setResponseTime(new Date());
		rasoiyyaApiLogs.setStatus(rasoiyyaApiLogsDto.getStatus());
		rasoiyyaApiLogs.setRequestedData(rasoiyyaApiLogsDto.getRequestedData());
		rasoiyyaApiLogs.setResponsedData(rasoiyyaApiLogsDto.getResponseData());
		rasoiyyaApiLogs.setUserId(rasoiyyaApiLogsDto.getUserName());		
		rasoiyyaApiLogs = rasoiyyaApiLogsRepositoy.save(rasoiyyaApiLogs);
		return rasoiyyaApiLogs;
	}

}
