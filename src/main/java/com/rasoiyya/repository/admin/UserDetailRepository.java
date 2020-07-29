package com.rasoiyya.repository.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rasoiyya.domain.UserLogin;
import java.util.Optional;

public interface UserDetailRepository extends JpaRepository<UserLogin,Integer> {


    Optional<UserLogin> findByUsername(String name);

}
