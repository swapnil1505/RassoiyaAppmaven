package com.rasoiyya.service.customer.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rasoiyya.domain.Address;
import com.rasoiyya.domain.City;
import com.rasoiyya.domain.Customer;
import com.rasoiyya.domain.Person;
import com.rasoiyya.domain.RasoiyyaApiLogs;
import com.rasoiyya.domain.Role;
import com.rasoiyya.domain.State;
import com.rasoiyya.domain.UserAddress;
import com.rasoiyya.domain.UserLogin;
import com.rasoiyya.dto.common.AddressRequest;
import com.rasoiyya.dto.common.RasoiyyaApiLogsDto;
import com.rasoiyya.dto.customer.CustomerRegistrationRequest;
import com.rasoiyya.repository.common.AddressRepository;
import com.rasoiyya.repository.common.PersonRepository;
import com.rasoiyya.repository.common.RasoiyyaApiLogsRepositoy;
import com.rasoiyya.repository.common.UserAddressRepository;
import com.rasoiyya.repository.common.UserLoginRepository;
import com.rasoiyya.repository.customer.CustomerRepository;
import com.rasoiyya.service.customer.CustomerRegistrationService;
import com.rasoiyya.util.StringUtils;

/**
 * The CustomerRegistrationServiceImpl.
 * 
 * @author suraj singh
 *
 */
@Service
public class CustomerRegistrationServiceImpl implements CustomerRegistrationService {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerRegistrationServiceImpl.class);

	@Autowired
	private UserLoginRepository userLoginRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private UserAddressRepository userAddressRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private RasoiyyaApiLogsRepositoy rasoiyyaApiLogsRepositoy;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Transactional
	@Override
	public void createCustomerRegistration(CustomerRegistrationRequest customerRegistrationRequest) throws Exception {
		try {
			UserLogin userLogin = getUserLogin(customerRegistrationRequest);
			// Save UserLogin
			userLogin = userLoginRepository.save(userLogin);
			log.info("User Login Data Save Successfully");			
			Person person = getPerson(customerRegistrationRequest);
			person.setUserLogin(userLogin);			
			person = personRepository.save(person);
			log.info("Person Data Save Successfully");
			
			if (customerRegistrationRequest.getAddressList() != null && customerRegistrationRequest.getAddressList().size() > 0) {
				for (AddressRequest addressRequest : customerRegistrationRequest.getAddressList()) {
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
					
					address.setDistrict(addressRequest.getDistrict());
					address.setGeoLocation(addressRequest.getGeo_location());
					address.setPincode(addressRequest.getPin_code());
					
					// Save the Address
					address = addressRepository.save(address);
					log.info("Address Data Save Successfully");
					
					UserAddress userAddress = new UserAddress();
					userAddress.setAddressId(address.getAddressId());
					userAddress.setUserLoginId(userLogin.getUserId());
					userAddress.setIsCurrentAddress(addressRequest.getIs_current_address());
					// Save User - Address Mapping Data
					userAddressRepository.save(userAddress);		
					log.info("User-Address mapping Data updated Successfully");
				}
			}
			
			Customer customer = new Customer();
			customer.setPerson(person);
			
			//Saving the customer Data
			customerRepository.save(customer);
			log.info("Customer Registration SuccessFully in Service !!!!");
			
		} catch (Exception e) {
			log.info("User Login Failed !!!");
			e.printStackTrace();
			throw e;
		}

	}
	
	private UserLogin getUserLogin(CustomerRegistrationRequest customerRegistrationRequest) {
		UserLogin userLogin = new UserLogin();
		userLogin.setUsername(customerRegistrationRequest.getUser_name());
		String encodedPassword = passwordEncoder.encode(customerRegistrationRequest.getPassword());
		userLogin.setPassword(encodedPassword);
		userLogin.setIsActive(true);
		userLogin.setIsParent("N");
		Role role = new Role();
		role.setRoleId(4);
		userLogin.setRoles(role);
				
		return userLogin;
	}
	
	private Person getPerson(CustomerRegistrationRequest customerRegistrationRequest) {
		Person person = new Person();
		person.setFirstname(customerRegistrationRequest.getFirst_name());
		person.setLastname(customerRegistrationRequest.getLast_name());
		person.setEmail(customerRegistrationRequest.getEmail_id());
		person.setMobileNo(customerRegistrationRequest.getMobile_number());
		person.setDateOfBirth(customerRegistrationRequest.getDate_of_birth());
		person.setGender(customerRegistrationRequest.getGender());
		return person;
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
