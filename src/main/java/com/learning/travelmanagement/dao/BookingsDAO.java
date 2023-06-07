package com.learning.travelmanagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.travelmanagement.model.Bookings;

public interface BookingsDAO extends JpaRepository<Bookings, Integer>{
	
	public List<Bookings> findByClientId(int id);
	
	public List<Bookings> findByCabId(int id);

}
