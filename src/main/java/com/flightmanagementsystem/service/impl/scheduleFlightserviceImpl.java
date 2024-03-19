package com.flightmanagementsystem.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightmanagementsystem.Entity.Airport;
import com.flightmanagementsystem.Entity.Flight;
import com.flightmanagementsystem.Entity.Schedule;
import com.flightmanagementsystem.Entity.ScheduledFlight;
import com.flightmanagementsystem.exception.ResourceNotFoundException;
import com.flightmanagementsystem.exception.ScheduleAlreadyExistsException;
import com.flightmanagementsystem.repository.IairportRepository;
import com.flightmanagementsystem.repository.IscheduleFlightRepository;
import com.flightmanagementsystem.service.IscheduleFlightService;
@Service
public class scheduleFlightserviceImpl implements IscheduleFlightService {

	@Autowired
	private IscheduleFlightRepository s;
	
	@Autowired
	private IairportRepository air;
	 
	@Override
	public ScheduledFlight ScheduledFlight(ScheduledFlight schedule) throws ScheduleAlreadyExistsException {
		 Optional<?> a=s.findById(schedule.getFid());
		  
		 if(a.isPresent())
		 {
			 throw new ScheduleAlreadyExistsException(" ScheduleAlready is done");
		 }
		return s.save(schedule);
	}

@Override
	public  List<ScheduledFlight> viewScheduledFlight(Airport startAirportId, Airport endAirportId,
			LocalDate date)  {
		/*
		 * ScheduledFlight sc=s.findByAirportName( );
		 */
	
 
return null;
}

	@Override
	public  ScheduledFlight viewScheduledFlight(long scheduleF) throws ResourceNotFoundException {
		 
		return s.findById(scheduleF).orElseThrow(()-> new ResourceNotFoundException("schedule not thare"));
	}

	@Override
	public List< ScheduledFlight> viewAllScheduledFlight( ) throws ResourceNotFoundException {
		 List<ScheduledFlight>ist=s.findAll();
		 if(ist.isEmpty())
		 {
			 throw new ResourceNotFoundException("no schedule are in database");
		 }
		 else
		 {
			 return ist;
		 }
		
	}

	@Override
	public  ScheduledFlight modifyScheduledFlight(Flight flight, Schedule schedule,
			int time) throws ResourceNotFoundException {
		
		ScheduledFlight a=s.findById(schedule.getAirId()).orElseThrow(()->new 
				ResourceNotFoundException("flight is not avibel"));
		a.setAvalibleSeats(flight.getSeatCapacity());
				return null;
	}

	@Override
	public ScheduledFlight deleteScheduledFlight(long flightId) throws ResourceNotFoundException {
	 ScheduledFlight sc=s.findById(flightId).orElseThrow(()->new ResourceNotFoundException("not avibel"));
	 
	 s.delete(sc);
		return null;
	}

	@Override
	public  ScheduledFlight validateScheduledFlight(ScheduledFlight schf) {
 
		return null;
	}

}
