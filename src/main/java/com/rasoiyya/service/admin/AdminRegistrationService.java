package com.rasoiyya.service.admin;

import com.rasoiyya.domain.RasoiyyaApiLogs;
import com.rasoiyya.dto.admin.AdminRegistrationRequest;
import com.rasoiyya.dto.common.RasoiyyaApiLogsDto;

public interface AdminRegistrationService {

	void getAdminRegistration(AdminRegistrationRequest adminRegistrationRequest) throws Exception ;

	RasoiyyaApiLogs saveApiLogs(RasoiyyaApiLogsDto rasoiyyaApiLogsDto);
	
}
