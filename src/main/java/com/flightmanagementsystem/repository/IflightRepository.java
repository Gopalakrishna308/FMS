package com.flightmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightmanagementsystem.Entity.Flight;


@Repository
public interface IflightRepository extends JpaRepository<Flight, Long> {

}
