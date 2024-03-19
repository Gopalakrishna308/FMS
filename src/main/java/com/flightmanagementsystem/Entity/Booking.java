package com.flightmanagementsystem.Entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  
	private  long bookingId;
	@OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	private Customer customerId;
	
	private LocalDateTime bookingDate;
	
	 @OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	 private List<Passenger> passengerList;
	
	private double ticketCost;
	
	@OneToOne (cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	private Flight flight;
	
	private int noOfPassengers;
}
