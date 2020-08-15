package com.rasoiyya.web.rest.common;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rasoiyya.dto.UserLoginRequest;
import com.rasoiyya.service.common.OTPLogService;
import com.rasoiyya.service.common.UserLoginService;

/**
 * 
 * @author ravi.shakya
 *
 */
@RestController
@RequestMapping("/login/v1")
public class LoginResourceController {

	@Autowired
	private UserLoginService loginService;

	@Autowired
	private OTPLogService otpLogService;

	private Logger log = LoggerFactory.getLogger(LoginResourceController.class);

	@PostMapping(path = "/otpuserlogin", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public String sendOTP(@RequestBody UserLoginRequest userLoginRequest) {
		try {
			log.info("Uer mobile no :- " + userLoginRequest.getMobile());
			if (StringUtils.isEmpty(userLoginRequest.getMobile())) {
				return "Please provide valid mobile number";
			}
			if (loginService.isValidMobile(userLoginRequest.getMobile())) {
				String otp = otpLogService.sendOTP(userLoginRequest.getMobile());
				otpLogService.saveMobileOTP(userLoginRequest.getMobile(), otp);
				log.info("OTP send Sucessfully to your mobile no : {} ", userLoginRequest.getMobile());
			} else {
				log.info("Mobile number is not exist ");
				return "Mobile number is not exist";
			}
			return "OTP sent Sucessfully";
		} catch (Exception e) {
			e.printStackTrace();
			return "OTP send Failed";
		}

	}

	@PostMapping(path = "/varifyuserlogin", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public String varifyOTP(@RequestBody UserLoginRequest userLoginRequest) {
		log.info("Varify OTP, User mobile no {} and otp {} ", userLoginRequest.getMobile(), userLoginRequest.getOtp());

		if (StringUtils.isEmpty(userLoginRequest.getMobile()) && StringUtils.isEmpty(userLoginRequest.getOtp())) {
			return "Please provide mobile number and otp";
		}
		// first varify mobile with user login table
		if (loginService.isValidMobile(userLoginRequest.getMobile())) {
			// varify mobile otp
			boolean otp = otpLogService.varifyOTP(userLoginRequest.getMobile(), userLoginRequest.getOtp());
			if (otp) {
				log.info("Login Sucessfully !");
				return "Login Sucessfully";
			}
		} else {
			log.info("Mobile number is not exist ");
		}

		return "Login Failed";
	}
}
