package com.rasoiyya.repository.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rasoiyya.domain.UserLogin;
@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, Integer> {

	UserLogin findByUsername(String userName);

}
