package com.rasoiyya.service.customer;

import com.rasoiyya.domain.RasoiyyaApiLogs;
import com.rasoiyya.dto.common.RasoiyyaApiLogsDto;
import com.rasoiyya.dto.customer.CustomerRegistrationRequest;

public interface CustomerRegistrationService {

	void createCustomerRegistration(CustomerRegistrationRequest customerRegistrationRequest) throws Exception ;

	RasoiyyaApiLogs saveApiLogs(RasoiyyaApiLogsDto rasoiyyaApiLogsDto);
	
}
