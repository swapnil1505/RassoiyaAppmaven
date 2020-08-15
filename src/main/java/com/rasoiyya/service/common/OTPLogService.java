package com.rasoiyya.service.common;

import com.rasoiyya.domain.OTPLog;

/**
 * 
 * @author ravi.shakya
 *
 */
public interface OTPLogService {

	OTPLog saveMobileOTP(String mobile, String otp);

	OTPLog findByMobile(String mobile);

	String sendOTP(String mobile);

	boolean varifyOTP(String mobile, String otp);

}
