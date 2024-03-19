package com.flightmanagementsystem.Entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
//@PrimaryKeyJoinColumn(name="airport_id")
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long airId;
	
	@OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY) 
	
	private Airport sourceAirport;
	 @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY) 
	private Airport destinationAirport;
	
	private LocalDateTime arrivalTime;
	
	private LocalDateTime departureTime;
	
}
