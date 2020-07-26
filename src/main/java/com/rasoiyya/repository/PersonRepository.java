package com.rasoiyya.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rasoiyya.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{

}
