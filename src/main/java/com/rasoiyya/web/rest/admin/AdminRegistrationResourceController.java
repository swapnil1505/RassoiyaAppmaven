package com.rasoiyya.web.rest.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rasoiyya.dto.admin.AdminRegistrationRequest;
import com.rasoiyya.dto.admin.AdminRegistrationResponse;
import com.rasoiyya.web.rest.LoginResourceController;

@RestController
@RequestMapping("/admin/v1")
public class AdminRegistrationResourceController {

	Logger log = LoggerFactory.getLogger(LoginResourceController.class);
	
	@PostMapping(path="/adminRegistration",produces= {MediaType.APPLICATION_JSON_VALUE},consumes= {MediaType.APPLICATION_JSON_VALUE})
	public AdminRegistrationResponse adminRegistration(@RequestBody  AdminRegistrationRequest adminRegistrationRequest) {
		AdminRegistrationResponse response = new AdminRegistrationResponse();
		try {
					
			log.info("Admin Regitration Sucessfully !");
			return response;
		} catch (Exception e) {
			log.error("Admin Regitration Failed !!");
			e.printStackTrace();		
			return response;
		}
		
	}
}
