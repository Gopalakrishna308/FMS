package com.flightmanagementsystem.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Passenger {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pnrNumber;
	
	private String passengerName;
	
	private int passengerAge;
	
	private long passengerUIN;
	
	private Double luggage;
 
	   
}
