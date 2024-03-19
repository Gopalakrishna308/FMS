package com.flightmanagementsystem.service;

import java.util.List;

import com.flightmanagementsystem.Entity.Customer;
import com.flightmanagementsystem.exception.CustomerAlreadyExistsException;
import com.flightmanagementsystem.exception.InvalidCredentials;
import com.flightmanagementsystem.exception.ResourceNotFoundException;

public interface IcustiomerService {

public Customer addUser(Customer customer) throws CustomerAlreadyExistsException;

public Customer viewCustomer(long  customerId) throws ResourceNotFoundException;

public List<Customer> getAllCustomer() throws ResourceNotFoundException;

public Customer updateCustomer(Customer customer) throws ResourceNotFoundException;

public Customer deleteCustomer(long customerId) throws ResourceNotFoundException;

public Customer validateCustomer(String name,String password) throws ResourceNotFoundException, InvalidCredentials;
}
