package com.rasoiyya.web.rest.admin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rasoiyya.domain.RasoiyyaApiLogs;
import com.rasoiyya.dto.admin.AdminProfileResponse;
import com.rasoiyya.dto.admin.AdminRegistrationRequest;
import com.rasoiyya.dto.admin.AdminRegistrationResponse;
import com.rasoiyya.dto.admin.AdminUpdateProfileRequest;
import com.rasoiyya.dto.admin.ViewAdminProfileRequest;
import com.rasoiyya.dto.common.RasoiyyaApiLogsDto;
import com.rasoiyya.service.admin.AdminProfileService;
import com.rasoiyya.service.admin.AdminRegistrationService;
import com.rasoiyya.util.GlobalConstants;
import com.rasoiyya.util.StringUtils;

@RestController
@RequestMapping("/admin/v1")
public class AdminResourceController {

	@Autowired
	AdminRegistrationService adminRegistrationService;
	
	@Autowired
	AdminProfileService adminProfileService;
	
	Logger log = LoggerFactory.getLogger(AdminResourceController.class);
	
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
		} catch (DataIntegrityViolationException dataViolationException) {
			log.error("Admin Regitration Failed !!");
			response.setStatus(GlobalConstants.ERROR);
			response.setStatus_code(GlobalConstants.ERROR_CODE);
			response.setStatus_message(GlobalConstants.ERROR_USER_NAME_UNIQUE);
			dataViolationException.printStackTrace();
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
			if (StringUtils.isNotEmptyStr(adminRegistrationRequest.getCreated_by())) { 
				rasoiyyaApiLogsDto.setModifiedBy(adminRegistrationRequest.getCreated_by());
				rasoiyyaApiLogsDto.setCreatedBy(adminRegistrationRequest.getCreated_by());
			}
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
	
	
	
	@PostMapping(path="/viewProfile",produces= {MediaType.APPLICATION_JSON_VALUE},consumes= {MediaType.APPLICATION_JSON_VALUE})
	public AdminProfileResponse viewProfile(@RequestBody  ViewAdminProfileRequest viewAdminProfileRequest) { 
		AdminProfileResponse response = new AdminProfileResponse();
		Date requestedTime = new Date();
		try {		
			response = adminProfileService.viewProfile(viewAdminProfileRequest);
			
		} catch (Exception e) {
			log.error("Admin View Profile Failed !!");
			response.setStatus(GlobalConstants.ERROR);
			response.setStatus_code(GlobalConstants.ERROR_CODE);
			response.setStatus_message(GlobalConstants.VIEW_PROFILE_UNSUCESSFULL);
			e.printStackTrace();		
			return response;
		} finally {
			RasoiyyaApiLogsDto rasoiyyaApiLogsDto = new RasoiyyaApiLogsDto();
			rasoiyyaApiLogsDto.setRequestedData(viewAdminProfileRequest.toString());
			rasoiyyaApiLogsDto.setResponseData(response.toString());
			rasoiyyaApiLogsDto.setLogin_ip("");
			rasoiyyaApiLogsDto.setStatus(response.getStatus());
			rasoiyyaApiLogsDto.setRequestTime(requestedTime);
			rasoiyyaApiLogsDto.setCreatedBy(viewAdminProfileRequest.getUser_name());
			rasoiyyaApiLogsDto.setModifiedBy(viewAdminProfileRequest.getUser_name());
			rasoiyyaApiLogsDto.setServiceName(GlobalConstants.ADMIN_VIEW_PROFILE);		
			rasoiyyaApiLogsDto.setRequestuid(viewAdminProfileRequest.getRequestuid());
			
			RasoiyyaApiLogs rasoiyyaApiLogs = adminRegistrationService.saveApiLogs(rasoiyyaApiLogsDto);
			log.error("Rasoiyya Api Logs save Sucessfull for View Profile !!");
			if (rasoiyyaApiLogs != null) {
				DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				response.setResponse_time(df.format(rasoiyyaApiLogs.getRequestTime()));
				response.setRequestuid(rasoiyyaApiLogs.getRequestuid());
				response.setApi_log_id(Integer.toString(rasoiyyaApiLogs.getApiLogsId()));
			}
		}
		return response;
	}
	
	@PostMapping(path="/updateProfile",produces= {MediaType.APPLICATION_JSON_VALUE},consumes= {MediaType.APPLICATION_JSON_VALUE})
	public AdminProfileResponse upateProfile(@RequestBody  AdminUpdateProfileRequest adminUpdateProfileRequest) { 
		AdminProfileResponse response = new AdminProfileResponse();
		Date requestedTime = new Date();
		try {		
			response = adminProfileService.updateProfile(adminUpdateProfileRequest);
		} catch (Exception e) {
			log.error("Admin Profile Update Failed !!");
			response.setStatus(GlobalConstants.ERROR);
			response.setStatus_code(GlobalConstants.ERROR_CODE);
			response.setStatus_message(GlobalConstants.UPDATE_PROFILE_UNSUCESSFULL);
			e.printStackTrace();		
			return response;
		} finally {
			RasoiyyaApiLogsDto rasoiyyaApiLogsDto = new RasoiyyaApiLogsDto();
			rasoiyyaApiLogsDto.setRequestedData(response.toString());
			rasoiyyaApiLogsDto.setResponseData(response.toString());
			rasoiyyaApiLogsDto.setLogin_ip("");
			rasoiyyaApiLogsDto.setStatus(response.getStatus());
			rasoiyyaApiLogsDto.setRequestTime(requestedTime);
			rasoiyyaApiLogsDto.setCreatedBy(response.getUser_name());
			rasoiyyaApiLogsDto.setModifiedBy(response.getUser_name());
			rasoiyyaApiLogsDto.setServiceName(GlobalConstants.ADMIN_UPDATE_PROFILE);		
			rasoiyyaApiLogsDto.setRequestuid(response.getRequestuid());
			
			RasoiyyaApiLogs rasoiyyaApiLogs = adminRegistrationService.saveApiLogs(rasoiyyaApiLogsDto);
			log.error("Rasoiyya Api Logs save Sucessfull for View Profile !!");
			if (rasoiyyaApiLogs != null) {
				DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				response.setResponse_time(df.format(rasoiyyaApiLogs.getRequestTime()));
				response.setRequestuid(rasoiyyaApiLogs.getRequestuid());
				response.setApi_log_id(Integer.toString(rasoiyyaApiLogs.getApiLogsId()));
			}
		}
		return response;
	}
}
