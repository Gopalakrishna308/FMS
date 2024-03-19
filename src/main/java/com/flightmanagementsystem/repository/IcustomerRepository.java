package com.flightmanagementsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flightmanagementsystem.Entity.Customer;

@Repository
public interface IcustomerRepository extends JpaRepository<Customer, Long> {

	@Query(value="select c from Customer c where c.customerName=?1")
	public Optional<Customer>  getCustomerByName(String customerName );

}
