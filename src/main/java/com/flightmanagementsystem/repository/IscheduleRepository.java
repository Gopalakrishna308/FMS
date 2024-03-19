package com.flightmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flightmanagementsystem.Entity.Schedule;

public interface IscheduleRepository extends JpaRepository<Schedule, Long> {

}
