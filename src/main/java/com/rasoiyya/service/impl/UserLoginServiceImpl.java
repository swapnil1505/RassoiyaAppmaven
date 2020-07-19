package com.rasoiyya.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rasoiyya.domain.UserLogin;
import com.rasoiyya.dto.UserLoginRequest;
import com.rasoiyya.repository.UserLoginRepository;
import com.rasoiyya.service.UserLoginService;

@Service
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	UserLoginRepository userLoginRepository;
	
	@Override
	public void getLogin(UserLoginRequest userLoginRequest) {
		UserLogin userLogin = new UserLogin();
		userLogin.setUsername(userLoginRequest.getUser_name());
		userLogin.setPassword(userLoginRequest.getPassword());
		userLoginRepository.save(userLogin);
	}

}
