package com.rasoiyya.service.common.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rasoiyya.domain.Person;
import com.rasoiyya.domain.UserLogin;
import com.rasoiyya.dto.UserLoginRequest;
import com.rasoiyya.repository.common.PersonRepository;
import com.rasoiyya.repository.common.UserLoginRepository;
import com.rasoiyya.service.common.UserLoginService;

/**
 * 
 * @author ravi.shakya
 *
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	private UserLoginRepository userLoginRepository;

	@Autowired
	private PersonRepository personRepository;

	Logger log = LoggerFactory.getLogger(UserLoginServiceImpl.class);

	public void loginWithOTP(UserLoginRequest userLoginRequest) {
		UserLogin userLogin = new UserLogin();
		userLogin.setUsername(userLoginRequest.getUser_name());
		userLogin.setPassword(userLoginRequest.getPassword());
		userLoginRepository.save(userLogin);
	}

	@Override
	public boolean isValidMobile(String mobileNo) {
		log.info("varifing moblie number!!");
		Person person = personRepository.findPersonByMobile(mobileNo);
		return person != null ? true : false;
	}

}
