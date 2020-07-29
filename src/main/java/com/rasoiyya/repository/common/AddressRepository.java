package com.rasoiyya.repository.common;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rasoiyya.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

	@Query ("select a from Address a where a.addressId = :addressId ")
	List<Address> findAddressById(@Param("addressId") Integer addressId);

}
