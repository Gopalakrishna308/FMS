package com.flightmanagementsystem.service;

import java.text.ParseException;
import java.util.List;

import com.flightmanagementsystem.Entity.Booking;
import com.flightmanagementsystem.Entity.Passenger;
import com.flightmanagementsystem.exception.BookingAlreadyExistsException;
import com.flightmanagementsystem.exception.InvalidCredentials;
import com.flightmanagementsystem.exception.ResourceNotFoundException;

public interface IbookingService {

	public Booking addBooking(Booking booking) throws BookingAlreadyExistsException; 
	
	public Booking modifyBooking(Booking booking) throws ResourceNotFoundException;
	
	public Booking viewBooking(long bokkingId) throws ResourceNotFoundException;
	
	public List<Booking> getAllBooking( ) throws ResourceNotFoundException;
	
	public Booking deleteBookig(long BookingId) throws ResourceNotFoundException;
	
	public Booking validateBooking(Booking bookingDate) throws ResourceNotFoundException, InvalidCredentials, ParseException;
	
	public Passenger validatePassenger(Passenger passneger);
	
	
}
