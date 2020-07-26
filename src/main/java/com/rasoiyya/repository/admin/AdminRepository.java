package com.rasoiyya.repository.admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rasoiyya.domain.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

}
