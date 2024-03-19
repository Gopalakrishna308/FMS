package com.flightmanagementsystem.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
 

public class Customer {

 
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private  long customerId;
	
	private  String customerType;
	
	private String customerName;
	
	private   String  customerPassword;
	
	private long customersPhone;
	
	private  String email;
	
	 
}
