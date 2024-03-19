package com.flightmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightmanagementsystem.Entity.Customer;
import com.flightmanagementsystem.exception.InvalidCredentials;
import com.flightmanagementsystem.exception.ResourceNotFoundException;
import com.flightmanagementsystem.service.IcustiomerService;

@RestController
@RequestMapping("/api/Customer")
@CrossOrigin
public class customerController {
	
	@Autowired
	private IcustiomerService customerservice;
	
	@PostMapping("/add_Customer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws Exception
	{
		if(customer == null)
		{
			throw new Exception("object is null");
		}
		else
		{
			return new ResponseEntity<Customer>(customerservice.addUser(customer),HttpStatus.CREATED);
	}
	}
	
	@GetMapping("/viewCustomerById/{customerId}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable long customerId) throws ResourceNotFoundException, com.example.On.Road.Vehicle.Breakdown.Assistance.exceptions.ResourceNotFoundException
	{
		return new ResponseEntity<Customer>(customerservice.viewCustomer(customerId),HttpStatus.OK);
	}
	@GetMapping("/viewAllCustomer")
	public ResponseEntity<List<Customer>> getAllCustomer() throws ResourceNotFoundException, com.example.On.Road.Vehicle.Breakdown.Assistance.exceptions.ResourceNotFoundException 
	{
		return new ResponseEntity<List<Customer>>(customerservice.getAllCustomer(),HttpStatus.OK);
	}

	@PutMapping("/update-Customer")
	public ResponseEntity<Customer>updateCustomer(@RequestBody Customer customer) throws Exception
	{
		if(customer == null)
		{
			throw new Exception("object is null");
		}
		else 
		{
			return new ResponseEntity<Customer>(customerservice.updateCustomer(customer),HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/delete/{customerId}")
	public ResponseEntity<Customer>deleteCustomer(@PathVariable long customerId) throws Exception
	{
		if(customerId == 0)
		{
			throw new Exception(" customer Id  should't be Zero");
		}
		else
			return new ResponseEntity<Customer>(customerservice.deleteCustomer(customerId),HttpStatus.OK);
	}
	
	@GetMapping("/validate/{name}{password}")
	public ResponseEntity<Customer> validateCustomer(@PathVariable String name,@PathVariable String password) throws InvalidCredentials, ResourceNotFoundException, com.example.On.Road.Vehicle.Breakdown.Assistance.exceptions.ResourceNotFoundException
	{
		if (name==null&& name==""&& password==null && password==" ")
			throw new InvalidCredentials("name and password is wrong");
		else
			return new  ResponseEntity<Customer>(customerservice.validateCustomer(name,password),HttpStatus.ACCEPTED);
		}
	
	
	
	
	
}



