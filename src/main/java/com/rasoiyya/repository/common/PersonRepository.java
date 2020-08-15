package com.rasoiyya.repository.common;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rasoiyya.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{

	@Query("select p from Person p where p.userLogin.userId = :userId ")
	List<Person> findByUserLoginId(@Param("userId") int userId);

	@Query("select case when count(p)> 0 then true else false end from Person p where p.mobileNo = :mobileNo")
	boolean userExistsByMobile(@Param("mobileNo") String mobileNo);
}

