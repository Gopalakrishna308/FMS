package com.flightmanagementsystem.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.flightmanagementsystem.Entity.Booking;
@Repository
public interface IBookingRepository extends JpaRepository<Booking,Long> {

	
	@Query(value="select c from Booking c where c.bookingDate=?1")
      public 	Booking findByBookingDate(Date date);

}
