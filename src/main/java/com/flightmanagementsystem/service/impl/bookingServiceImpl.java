package com.flightmanagementsystem.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightmanagementsystem.Entity.Booking;
import com.flightmanagementsystem.Entity.Passenger;
import com.flightmanagementsystem.exception.BookingAlreadyExistsException;
import com.flightmanagementsystem.exception.InvalidCredentials;
import com.flightmanagementsystem.exception.ResourceNotFoundException;
import com.flightmanagementsystem.repository.IBookingRepository;
import com.flightmanagementsystem.service.IbookingService;
@Service
public class bookingServiceImpl implements IbookingService {

	
	@Autowired
	private IBookingRepository bookingserviceimpl;
	
	@Override
	public Booking addBooking(Booking booking) throws BookingAlreadyExistsException {
	 Optional<?>a=bookingserviceimpl.findById(booking.getBookingId());
	  
	 Booking ad=null;
	 
	 if(a.isPresent())
	 {
		 throw new BookingAlreadyExistsException("booking is already present");
	 }
		return bookingserviceimpl.save(booking);
	}

	@Override
	public Booking modifyBooking(Booking booking) throws ResourceNotFoundException {
	   Booking b=bookingserviceimpl.findById(booking.getBookingId()).orElseThrow(()->
	   new ResourceNotFoundException("booking is not avilabel from database"));
	   b.setBookingDate(booking.getBookingDate());
	   b.setFlight(booking.getFlight());
	   b.setNoOfPassengers(booking.getNoOfPassengers());
	   b.setTicketCost(booking.getTicketCost());
	   b.setPassengerList(booking.getPassengerList());
	   
	   
		return bookingserviceimpl.save(b);
	}

	@Override
	public Booking viewBooking(long bokkingId) throws ResourceNotFoundException {
		   
		return bookingserviceimpl.findById(bokkingId).orElseThrow(()-> new ResourceNotFoundException("booking is not thare"));
	}

	@Override
	public List<Booking> getAllBooking() throws ResourceNotFoundException {
	 List<Booking > list=bookingserviceimpl.findAll();
	 if(list.isEmpty())
	 {
		 throw new ResourceNotFoundException("NO Booking are in database");
	 }
	 else {
		return list;
	 }
	}

	@Override
	public Booking deleteBookig(long BookingId) throws ResourceNotFoundException {
		 Booking b=bookingserviceimpl.findById(BookingId).orElseThrow(()->new ResourceNotFoundException
				 ("Booking not found in the database"));
		 bookingserviceimpl.delete(b);
		return b;
	}

	 
	@Override
	public Booking validateBooking(Booking bookingDate) throws ResourceNotFoundException, InvalidCredentials, ParseException {
		SimpleDateFormat sim=new SimpleDateFormat("MM/DD/YY");
		Date req=sim.parse(bookingDate.toString());
				Booking c=bookingserviceimpl.findByBookingDate(req);
	 if(c.getBookingDate().equals(req))
	 {
		 return c;
	 }
				 
	 else
	 {
		 throw new InvalidCredentials("bookingDate is Invalide");
	 }
	}

	@Override
	public Passenger validatePassenger(Passenger passneger) {
		 
		return null;
	}

}
