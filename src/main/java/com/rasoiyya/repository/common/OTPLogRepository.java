package com.rasoiyya.repository.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rasoiyya.domain.OTPLog;

/**
 * 
 * @author ravi.shakya
 *
 */
public interface OTPLogRepository extends JpaRepository<OTPLog, Integer> {

	@Query("select case when count(c)> 0 then true else false end from OTPLog o where o.mobile = :mobile")
	boolean findByMobile(@Param("mobile") String mobileNo);

	@Query("select o from OTPLog o where o.mobile = :mobile")
	OTPLog getByMobile(@Param("mobile") String mobileNo);

}
