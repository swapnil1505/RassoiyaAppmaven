package com.rasoiyya.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rasoiyya.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
