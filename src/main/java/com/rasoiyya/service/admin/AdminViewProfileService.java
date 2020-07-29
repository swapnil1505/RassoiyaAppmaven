package com.rasoiyya.service.admin;

import com.rasoiyya.dto.admin.ViewAdminProfileRequest;
import com.rasoiyya.dto.admin.ViewAdminProfileResponse;

public interface AdminViewProfileService {

	ViewAdminProfileResponse viewProfile(ViewAdminProfileRequest viewAdminProfileRequest);

}
