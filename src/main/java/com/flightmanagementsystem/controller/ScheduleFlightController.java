package com.flightmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightmanagementsystem.Entity.ScheduledFlight;
import com.flightmanagementsystem.exception.ResourceNotFoundException;
import com.flightmanagementsystem.service.IscheduleFlightService;

@RestController
@RequestMapping("/api/sch")
public class ScheduleFlightController {
	
	@Autowired
	private IscheduleFlightService sche;
	
	
	@PostMapping("/add_schedule")
	public ResponseEntity<ScheduledFlight> ScheduledFlight(@RequestBody ScheduledFlight schedule) throws Exception
	{
		 if(schedule==null)
		 {
			 throw new Exception("object is null");
		 }
		 return new ResponseEntity<ScheduledFlight>(sche.ScheduledFlight(schedule),HttpStatus.CREATED);
	}
	
	@GetMapping("view_schedule/{scheduleF}")
	public ResponseEntity<ScheduledFlight>viewScheduledFlight(@PathVariable long scheduleF ) throws Exception
	{
		if(scheduleF==0)
		{
			throw new Exception("object is null");
		}
		else
		{
			return new ResponseEntity<ScheduledFlight>(sche.viewScheduledFlight(scheduleF),HttpStatus.OK);
		}
	}
	
	@GetMapping("viewAll")
	public ResponseEntity<List<ScheduledFlight>>viewAllScheduledFlight() throws ResourceNotFoundException
	{
		return new ResponseEntity<List<ScheduledFlight>>(sche.viewAllScheduledFlight(),HttpStatus.OK);
	}
	
	@DeleteMapping("deleteSchedule/{flightId}")
	public ResponseEntity<ScheduledFlight>deleteScheduledFlight(@PathVariable long flightId ) throws Exception
	{
		if(flightId==0)
		{
			throw new Exception("object is null");
		}
		else
		{
			return new ResponseEntity<ScheduledFlight>(sche.deleteScheduledFlight(flightId),HttpStatus.OK);
		}
		
	}
	
	 
	
	

}
