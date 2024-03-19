package com.flightmanagementsystem.service;

import java.time.LocalDate;
import java.util.List;

import com.flightmanagementsystem.Entity.Airport;
import com.flightmanagementsystem.Entity.Flight;
import com.flightmanagementsystem.Entity.Schedule;
import com.flightmanagementsystem.Entity.ScheduledFlight;
import com.flightmanagementsystem.exception.ResourceNotFoundException;
import com.flightmanagementsystem.exception.ScheduleAlreadyExistsException;

public interface IscheduleFlightService {
	
	public ScheduledFlight ScheduledFlight(ScheduledFlight schedule) throws ScheduleAlreadyExistsException;
	
	public List<ScheduledFlight>  viewScheduledFlight(Airport startAirportId, Airport endAirportId, LocalDate date) ;
	

	public ScheduledFlight viewScheduledFlight(long scheduleF ) throws ResourceNotFoundException;
	
	public List<ScheduledFlight> viewAllScheduledFlight( ) throws ResourceNotFoundException;
	
	public ScheduledFlight modifyScheduledFlight(Flight flight,Schedule schedule,int time) throws ResourceNotFoundException;
	
	public ScheduledFlight deleteScheduledFlight(long flightId) throws ResourceNotFoundException;
	
	public ScheduledFlight validateScheduledFlight (ScheduledFlight schf);
	

}
