package com.flightmanagementsystem.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightmanagementsystem.Entity.Customer;
import com.flightmanagementsystem.exception.CustomerAlreadyExistsException;
import com.flightmanagementsystem.exception.InvalidCredentials;
import com.flightmanagementsystem.exception.ResourceNotFoundException;
import com.flightmanagementsystem.repository.IcustomerRepository;
import com.flightmanagementsystem.service.IcustiomerService;
@Service
public class CustomerServiceImpl implements IcustiomerService {

	@Autowired
	private IcustomerRepository customerRepos;
	@Override
	public Customer addUser(Customer customer) throws CustomerAlreadyExistsException {
	 Optional<?>a=customerRepos.findById(customer.getCustomerId());
	 
	 Customer ad=null;
	 
	 if(a.isPresent()) {
		 throw new CustomerAlreadyExistsException("Customer already present  ");
		 
	 }
	 
		return customerRepos.save(customer);
	}

	@Override
	public Customer viewCustomer(long customerId) throws ResourceNotFoundException {
		 
		return customerRepos.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("Customer not found by id"));
	}

	@Override
	public List<Customer> getAllCustomer() throws ResourceNotFoundException {
		
		List<Customer> list=customerRepos.findAll();
		
		if(list.isEmpty())
		{
			throw new ResourceNotFoundException("No customer are there in data base");
		}
		else
		{
			return list;
		}
		 
		
		
		 
	}

	@Override
	public Customer updateCustomer(Customer customer) throws ResourceNotFoundException {
	 Customer   c=customerRepos.getCustomerByName(customer.getCustomerName()).orElseThrow(()-> new 
	
			 ResourceNotFoundException("customer is not avilabel from database"));
		
	 c.setCustomerPassword(customer.getCustomerPassword());
	 c.setCustomersPhone(customer.getCustomersPhone());
	 c.setEmail(customer.getEmail());
	 
	 
	 return customerRepos.save(c);
	}

	@Override
	public Customer deleteCustomer(long customerId) throws ResourceNotFoundException {
		Customer c=customerRepos.findById(customerId).orElseThrow(()->
		new ResourceNotFoundException("Customer not found in the database"));
		customerRepos.delete(c);
		return c;
	}

	@Override
	public Customer validateCustomer(String name, String password) throws ResourceNotFoundException, InvalidCredentials {
		Customer c=customerRepos.getCustomerByName(name) .orElseThrow(
				()->new ResourceNotFoundException("Invalide Credentials"));
				
		if(c.getCustomerName().equalsIgnoreCase(name)&& c.getCustomerPassword().equalsIgnoreCase(password))
		{
			return c;
		}
		else 
		{
			throw new InvalidCredentials("UserName or Password is Invalid");
		}
			
		
	  
	}

}
