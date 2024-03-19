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
public class Flight {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	 
	private long flightId;
	
	private  String carrierName;
	
	private String flightModel;
	
	private int seatCapacity;
	
}
