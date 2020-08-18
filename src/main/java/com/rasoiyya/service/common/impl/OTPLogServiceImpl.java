package com.rasoiyya.service.common.impl;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.rasoiyya.constants.MessageConstants;
import com.rasoiyya.domain.OTPLog;
import com.rasoiyya.domain.UserLogin;
import com.rasoiyya.repository.common.OTPLogRepository;
import com.rasoiyya.repository.common.UserLoginRepository;
import com.rasoiyya.service.common.OTPLogService;
import com.rasoiyya.util.GlobalConstants;

/**
 * 
 * @author ravi.shakya
 *
 */
@Service
public class OTPLogServiceImpl implements OTPLogService {

	@Autowired
	private OTPLogRepository oTPLogRepository;

	static RestTemplate restTemplate = new RestTemplate();

	Logger log = LoggerFactory.getLogger(OTPLogServiceImpl.class);

	@Override
	@Transactional
	public OTPLog saveMobileOTP(String mobile, String otp) {
		log.info("saving otp in db");
		Date requestedTime = new Date();
		OTPLog otpLog = new OTPLog();

		OTPLog byMobile = findByMobile(mobile);
		System.out.println(byMobile);
		if (byMobile != null) {
			otpLog = oTPLogRepository.findById(byMobile.getOtpId()).get();
			otpLog.setModifiedBy(GlobalConstants.USER_SELF);
			otpLog.setLastUpdatedDate(requestedTime);
			otpLog.setOtp(otp);
			return oTPLogRepository.save(otpLog);
		}
		otpLog.setOtp(otp);
		otpLog.setMobile(mobile);
		otpLog.setCreatedDate(requestedTime);
		otpLog.setLastUpdatedDate(requestedTime);
		otpLog.setCreatedBy(GlobalConstants.USER_SELF);
		return oTPLogRepository.save(otpLog);
	}

	@Override
	public OTPLog findByMobile(String mobile) {
		return oTPLogRepository.getByMobile(mobile);
	}

	@Override
	public boolean varifyOTP(String mobile, String otp) {
		OTPLog otpLog = findByMobile(mobile);
		if (otpLog == null) {
			log.info("Record is not found in otplog table");
		}
		return otpLog.getMobile().equals(mobile) && otpLog.getOtp().equals(otp);
	}

	@Override
	public String sendOTP(String mobile) {
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);
		headers.set(HttpHeaders.AUTHORIZATION, MessageConstants.AUTH_KEY);

		String otp = new DecimalFormat("000000").format(new Random().nextInt(999999));
		System.out.println(otp);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(MessageConstants.POST_URL)
				.queryParam("sender_id", MessageConstants.SENDER_ID).queryParam("language", "english")
				.queryParam("route", "qt").queryParam("numbers", mobile)
				.queryParam("message", MessageConstants.MESSAGE_TEMPLATE_ID)
				.queryParam("variables", MessageConstants.OTP_VARIBLE_LEN).queryParam("variables_values", otp);

		log.info("sending otp {} to {} ", otp, mobile);
		System.out.println("url : " + builder.build().encode().toUri());
		HttpEntity<?> entity = new HttpEntity<>(headers);

		ResponseEntity<String> messageRsponse = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.POST,
				entity, String.class);

		log.debug("response {}", messageRsponse.getBody());
		if (messageRsponse.getStatusCodeValue() != 200) {
			log.error("Message sending failed : {}", messageRsponse.getBody());
		}
		return otp;
	}
}
