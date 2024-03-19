package com.flightmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightmanagementsystem.Entity.Booking;
import com.flightmanagementsystem.exception.ResourceNotFoundException;
import com.flightmanagementsystem.service.IbookingService;

@RestController
@RequestMapping("/api/Booking")
public class bookingController {
	
	@Autowired
	private IbookingService bookingservice;
	
	
	@PostMapping("/add_booking")
	public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) throws Exception
	{
		if (booking ==null)
		{
			throw new Exception("object is null");
		}
		else
		{
			return new ResponseEntity<Booking>(bookingservice.addBooking(booking),HttpStatus.CREATED);
		}
	}
	
	@PutMapping("/modify")
	public ResponseEntity<Booking>modifyBooking(@RequestBody Booking booking) throws Exception
	{
		if(booking ==null)
		{
			throw new Exception("object is null");
			
		}
		else
		{
			return new ResponseEntity<Booking>(bookingservice.modifyBooking(booking),HttpStatus.OK);
		}
	}
	@GetMapping("/view_booking/{bokkinId}")
	public ResponseEntity<Booking>viewBooking(@PathVariable long bokkinId) throws Exception
	{
		if(bokkinId==0)
		{
			throw new Exception("object is null");
			
			
		}
		else
		{
			return new ResponseEntity<Booking>(bookingservice.viewBooking(bokkinId),HttpStatus.OK);
		}
	}
	
	@GetMapping("view_AllBooking")
	public ResponseEntity< List<Booking>>getAllBooking() throws ResourceNotFoundException
	{
		return new ResponseEntity<List<Booking>>(bookingservice.getAllBooking(),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete_booking/{BookingId}")
	public ResponseEntity<Booking>deleteBooking(@PathVariable long BookingId) throws Exception
	{
		if(BookingId == 0)
		{
			throw new Exception("object is null");
			
		}
		else
		{
			return new ResponseEntity<Booking>(bookingservice.deleteBookig(BookingId),HttpStatus.OK);
		}
	}
	@GetMapping("/validateBooking/{bookingDate}")
	public ResponseEntity<Booking> validateBooking(@PathVariable Booking bookingDate) throws Exception
	{
		if (bookingDate==null)
		{
			throw new Exception("object is null");
		}
		else
		{
			return new ResponseEntity<Booking>(bookingservice.validateBooking(bookingDate),HttpStatus.ACCEPTED);
		}
	}
	
	
	
	
	

}
