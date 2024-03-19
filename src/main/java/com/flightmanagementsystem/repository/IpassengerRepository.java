package com.flightmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightmanagementsystem.Entity.Passenger;

public interface IpassengerRepository extends JpaRepository<Passenger, Long> {

}
