package com.rasoiyya.web.rest.admin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rasoiyya.domain.RasoiyyaApiLogs;
import com.rasoiyya.dto.admin.AdminRegistrationRequest;
import com.rasoiyya.dto.admin.AdminRegistrationResponse;
import com.rasoiyya.dto.common.RasoiyyaApiLogsDto;
import com.rasoiyya.service.admin.AdminRegistrationService;
import com.rasoiyya.util.GlobalConstants;
import com.rasoiyya.web.rest.LoginResourceController;

@RestController
@RequestMapping("/admin/v1")
public class AdminRegistrationResourceController {

	@Autowired
	AdminRegistrationService adminRegistrationService;
	
	Logger log = LoggerFactory.getLogger(LoginResourceController.class);
	
	@PostMapping(path="/adminRegistration",produces= {MediaType.APPLICATION_JSON_VALUE},consumes= {MediaType.APPLICATION_JSON_VALUE})
	public AdminRegistrationResponse adminRegistration(@RequestBody  AdminRegistrationRequest adminRegistrationRequest) {
		AdminRegistrationResponse response = new AdminRegistrationResponse();
		Date requestedTime = new Date();
		try {
			adminRegistrationService.getAdminRegistration(adminRegistrationRequest);
			response.setStatus(GlobalConstants.SUCCESS);
			response.setStatus_code(GlobalConstants.SUCCESS_CODE);
			response.setStatus_message(GlobalConstants.ADMIN_REG_SUCCESSFULL);
			log.info("Admin Regitration Sucessfully !");
			return response;
		} catch (Exception e) {
			log.error("Admin Regitration Failed !!");
			response.setStatus(GlobalConstants.ERROR);
			response.setStatus_code(GlobalConstants.ERROR_CODE);
			response.setStatus_message(GlobalConstants.ADMIN_REG_UNSUCCESSFULL);
			e.printStackTrace();		
			return response;
		} finally {
			RasoiyyaApiLogsDto rasoiyyaApiLogsDto = new RasoiyyaApiLogsDto();
			rasoiyyaApiLogsDto.setRequestedData(adminRegistrationRequest.toString());
			rasoiyyaApiLogsDto.setResponseData(response.toString());
			rasoiyyaApiLogsDto.setLogin_ip("");
			rasoiyyaApiLogsDto.setStatus(response.getStatus());
			rasoiyyaApiLogsDto.setRequestTime(requestedTime);
			rasoiyyaApiLogsDto.setCreatedBy(GlobalConstants.SUPER_ADMIN);
			rasoiyyaApiLogsDto.setModifiedBy(GlobalConstants.SUPER_ADMIN);
			rasoiyyaApiLogsDto.setServiceName(GlobalConstants.ADMIN_REGISTARATION);		
			rasoiyyaApiLogsDto.setRequestuid(adminRegistrationRequest.getRequestuid());
			
			RasoiyyaApiLogs rasoiyyaApiLogs = adminRegistrationService.saveApiLogs(rasoiyyaApiLogsDto);
			log.error("RasoiyyaApiLogs save Sucessfull !!");
			if (rasoiyyaApiLogs != null) {
				DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				response.setResponse_time(df.format(rasoiyyaApiLogs.getRequestTime()));
				response.setRequestuid(rasoiyyaApiLogs.getRequestuid());
				response.setApi_log_id(Integer.toString(rasoiyyaApiLogs.getApiLogsId()));
			}
			
		}
		
	}
}
