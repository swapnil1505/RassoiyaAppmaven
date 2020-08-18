package com.rasoiyya.web.rest.customer;

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
import com.rasoiyya.dto.common.RasoiyyaApiLogsDto;
import com.rasoiyya.dto.customer.CustomerRegistrationRequest;
import com.rasoiyya.dto.customer.CustomerRegistrationResponse;
import com.rasoiyya.service.customer.CustomerRegistrationService;
import com.rasoiyya.util.GlobalConstants;
import com.rasoiyya.util.StringUtils;

/**
 * The CustomerResourceController.
 * 
 * @author suraj singh
 *
 */
@RestController
@RequestMapping("/customer/v1")
public class CustomerResourceController {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerResourceController.class);

	@Autowired
	private CustomerRegistrationService customerRegistrationService;
	
	@PostMapping(path="/customerRegistration",produces= {MediaType.APPLICATION_JSON_VALUE},consumes= {MediaType.APPLICATION_JSON_VALUE})
	public CustomerRegistrationResponse customerRegistration(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
		CustomerRegistrationResponse response = new CustomerRegistrationResponse();
		Date requestedTime = new Date();
		try {
			customerRegistrationService.createCustomerRegistration(customerRegistrationRequest);
			response.setStatus(GlobalConstants.SUCCESS);
			response.setStatus_code(GlobalConstants.SUCCESS_CODE);
			response.setStatus_message(GlobalConstants.CUSTOMER_REG_SUCCESSFULL);
			log.info("Customer Regitration Sucessfully !");
			return response;
		} catch (DataIntegrityViolationException dataViolationException) {
			log.error("Customer Regitration Failed !!");
			response.setStatus(GlobalConstants.ERROR);
			response.setStatus_code(GlobalConstants.ERROR_CODE);
			response.setStatus_message(GlobalConstants.ERROR_USER_NAME_UNIQUE);
			dataViolationException.printStackTrace();
			return response;
		} catch (Exception e) {
			log.error("Customer Regitration Failed !!");
			response.setStatus(GlobalConstants.ERROR);
			response.setStatus_code(GlobalConstants.ERROR_CODE);
			response.setStatus_message(GlobalConstants.CUSTOMER_REG_UNSUCCESSFULL);
			e.printStackTrace();		
			return response;
		} finally {
			RasoiyyaApiLogsDto rasoiyyaApiLogsDto = new RasoiyyaApiLogsDto();
			rasoiyyaApiLogsDto.setRequestedData(customerRegistrationRequest.toString());
			rasoiyyaApiLogsDto.setResponseData(response.toString());
			rasoiyyaApiLogsDto.setLogin_ip("");
			rasoiyyaApiLogsDto.setStatus(response.getStatus());
			rasoiyyaApiLogsDto.setRequestTime(requestedTime);
			rasoiyyaApiLogsDto.setCreatedBy(GlobalConstants.CUSTOMER);
			rasoiyyaApiLogsDto.setModifiedBy(GlobalConstants.CUSTOMER);
			if (StringUtils.isNotEmptyStr(customerRegistrationRequest.getCreated_by())) { 
				rasoiyyaApiLogsDto.setModifiedBy(customerRegistrationRequest.getCreated_by());
				rasoiyyaApiLogsDto.setCreatedBy(customerRegistrationRequest.getCreated_by());
			}
			rasoiyyaApiLogsDto.setServiceName(GlobalConstants.CUSTOMER_REGISTARATION);		
			rasoiyyaApiLogsDto.setRequestuid(customerRegistrationRequest.getRequestuid());
			
			RasoiyyaApiLogs rasoiyyaApiLogs = customerRegistrationService.saveApiLogs(rasoiyyaApiLogsDto);
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
