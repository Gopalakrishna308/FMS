package com.flightmanagementsystem.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
 
//@PrimaryKeyJoinColumn(name="Flight")
public class ScheduledFlight {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long fid;
	@OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinColumn(name="Flight_id")
	private  Flight flight;
	
	private int avalibleSeats;
	@OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	private Schedule  schedule;
	
	@ManyToOne
	//@JoinColumn(name = "startAirportId")
	private Airport airport;
	


}
