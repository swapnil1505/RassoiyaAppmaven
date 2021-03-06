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

	@Query("select p from Person p where p.mobileNo = :mobileNo")
	Person findPersonByMobile(@Param("mobileNo") String mobileNo);
}

