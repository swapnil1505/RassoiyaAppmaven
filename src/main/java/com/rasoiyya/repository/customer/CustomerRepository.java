package com.rasoiyya.repository.customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rasoiyya.domain.Customer;

/**
 * The CustomerRepository.
 * 
 * @author suraj singh
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	@Query ("select a from Customer a where a.person.personId = :personId")
	List<Customer> findByPersonId(@Param ("personId") int personId);
	
}
