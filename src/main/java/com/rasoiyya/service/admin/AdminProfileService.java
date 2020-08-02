package com.rasoiyya.service.admin;

import java.util.Map;

import com.rasoiyya.dto.admin.AdminProfileResponse;
import com.rasoiyya.dto.admin.AdminRegistrationRequest;
import com.rasoiyya.dto.admin.AdminRegistrationResponse;
import com.rasoiyya.dto.admin.AdminUpdateProfileRequest;
import com.rasoiyya.dto.admin.ViewAdminProfileRequest;

public interface AdminProfileService {

	public AdminProfileResponse viewProfile(ViewAdminProfileRequest viewAdminProfileRequest);
	public AdminProfileResponse updateProfile(AdminUpdateProfileRequest adminUpdateProfileRequest);
}
