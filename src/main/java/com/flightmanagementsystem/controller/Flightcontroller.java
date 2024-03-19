package com.flightmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightmanagementsystem.Entity.Flight;
import com.flightmanagementsystem.exception.ResourceNotFoundException;
import com.flightmanagementsystem.service.IflightService;

@RestController
@RequestMapping("/api/Flight")
public class Flightcontroller {
	
	@Autowired
	private IflightService fli;
	
	@PostMapping("/add_flight")
	public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) throws Exception
	{
		 Flight f=fli.addFlight(flight);
		 return new ResponseEntity<Flight>(f,HttpStatus.CREATED);
	}
	
	@PutMapping("/modifyFlight/{flightId}")
	public ResponseEntity<Flight> modifyFlight(@PathVariable Flight flightId) throws Exception
	{
		if(flightId==null)
		{
			throw new Exception("object is null");
		}
		else
		{
			return new ResponseEntity<Flight>( fli.modifyFlight(flightId),HttpStatus.OK);
		}
	}
	@GetMapping("ViewFlight/{flightId}")
	public ResponseEntity<Flight>viewFlight(@PathVariable long flightId) throws Exception
	{
		if(flightId==0)
		{
			throw new Exception("object is null");
		}
		else
		{
			return new ResponseEntity<Flight>(fli.viewFlight(flightId),HttpStatus.OK);
		}
	}
	@GetMapping("view_allFlight")
	public ResponseEntity<List<Flight>>viewAllList() throws ResourceNotFoundException
	{
		return new ResponseEntity<List<Flight>>(fli.viewAllList(),HttpStatus.OK);
	}

}
