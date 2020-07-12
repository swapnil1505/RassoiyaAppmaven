package com.rasoiyya.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rasoiyya.dto.UserLoginRequest;
import com.rasoiyya.service.UserLoginService;

@RestController
@RequestMapping("/login/v1")
public class LoginResourceController {
	
	@Autowired
	UserLoginService loginService;
	
	Logger log = LoggerFactory.getLogger(LoginResourceController.class);
	
	@PostMapping(path="/userlogin",/*produces= {MediaType.APPLICATION_JSON_VALUE},*/consumes= {MediaType.APPLICATION_JSON_VALUE})
	public String getLogin(@RequestBody  UserLoginRequest userLoginRequest) {
		try {
			log.info("Uer Name :- "+ userLoginRequest.getUser_name());
			log.info("Password :- "+ userLoginRequest.getPassword());
			loginService.getLogin(userLoginRequest);
			return "Login Sucessfully";
		} catch (Exception e) {
			e.printStackTrace();
			return "Login Failed";
		}
		
	}
}
