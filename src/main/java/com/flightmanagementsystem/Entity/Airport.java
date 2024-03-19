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
 
public class Airport {
	 @Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)	 
	 private long airportId;
	
	 private String airportName;
	
	 private String airportLocation;
	
	
	private String airportCode;

}
