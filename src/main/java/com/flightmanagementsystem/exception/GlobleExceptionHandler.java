package com.flightmanagementsystem.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.example.On.Road.Vehicle.Breakdown.Assistance.exceptions.ErrorDetails;

@RestControllerAdvice
public class GlobleExceptionHandler {

@ExceptionHandler(CustomerAlreadyExistsException.class)
public ResponseEntity<?> handelCustomerAlreadyExistsException(CustomerAlreadyExistsException ex,WebRequest request)
{
	ErrorDetails error=new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
   
	return  new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
}

@ExceptionHandler(ResourceNotFoundException.class)
public ResponseEntity<?> handelCustomerAlreadyExistsException(ResourceNotFoundException ex,WebRequest request)
{
	ErrorDetails error=new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
   
	return  new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
}
@ExceptionHandler(AirportAlreadyExistsException.class)
public ResponseEntity<?> handelCustomerAlreadyExistsException(AirportAlreadyExistsException ex,WebRequest request)
{
	ErrorDetails error=new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
   
	return  new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
}
@ExceptionHandler(BookingAlreadyExistsException.class)
public ResponseEntity<?> handelCustomerAlreadyExistsException(BookingAlreadyExistsException ex,WebRequest request)
{
	ErrorDetails error=new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
   
	return  new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
}
@ExceptionHandler(FlightAlreadyExistsException.class)
public ResponseEntity<?> handelCustomerAlreadyExistsException(FlightAlreadyExistsException ex,WebRequest request)
{
	ErrorDetails error=new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
   
	return  new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
}
@ExceptionHandler(InvalidCredentials.class)
public ResponseEntity<?> handelCustomerAlreadyExistsException(InvalidCredentials ex,WebRequest request)
{
	ErrorDetails error=new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
   
	return  new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
}
@ExceptionHandler(ScheduleAlreadyExistsException.class)
public ResponseEntity<?> handelCustomerAlreadyExistsException(ScheduleAlreadyExistsException ex,WebRequest request)
{
	ErrorDetails error=new ErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
   
	return  new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
}



}
