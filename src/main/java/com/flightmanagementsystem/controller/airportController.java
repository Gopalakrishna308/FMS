package com.flightmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightmanagementsystem.Entity.Airport;
import com.flightmanagementsystem.exception.ResourceNotFoundException;
import com.flightmanagementsystem.service.IairportService;

@Controller
@RestController
@RequestMapping("/api/Airport")
public class airportController {
	@Autowired
	private IairportService air;

	@PostMapping("add_airport")
	public ResponseEntity<Airport> addAirport(@RequestBody Airport airport) throws Exception {

		
		  if(airport==null) { throw new Exception("Object is null"); }
		  
		  else { return new
		  ResponseEntity<Airport>(air.addAirport(airport),HttpStatus.CREATED); }
		  
		 
	
	}

	@DeleteMapping("delete_airport/{airportId}")
	public ResponseEntity<Airport> deleteAirport(@PathVariable long airportId) throws Exception {
		if (airportId == 0) {
			throw new Exception("Object is null");

		} else {
			return new ResponseEntity<Airport>(air.deleteAirport(airportId), HttpStatus.OK);
		}
	}

	@GetMapping("getAllAirports")
	public ResponseEntity<List<Airport>> viewAllAirport() throws ResourceNotFoundException {
		return new ResponseEntity<List<Airport>>(air.viewAllAirport(), HttpStatus.OK);
	}

	@GetMapping("viewAirport/{airportId}")
	public ResponseEntity<Airport> viewAirport(@PathVariable long airportId) throws Exception {
		if (airportId == 0) {
			throw new Exception("object is null");

		} else {
			return new ResponseEntity<Airport>(air.viewAirport(airportId), HttpStatus.OK);
		}
	}
}
