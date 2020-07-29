package com.rasoiyya.repository.admin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rasoiyya.domain.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

	@Query ("select a from Admin a where a.person.personId = :personId")
	List<Admin> findByPersonId(@Param ("personId") int personId);

}
