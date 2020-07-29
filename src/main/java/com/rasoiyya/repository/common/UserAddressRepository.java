package com.rasoiyya.repository.common;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rasoiyya.domain.UserAddress;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress, Integer> {

	@Query("select au from UserAddress au where au.userLoginId = :userId ")
	List<UserAddress> findAddressByuserId(@Param("userId") int userId);

}
