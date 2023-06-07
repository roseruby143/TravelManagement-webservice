package com.learning.travelmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.travelmanagement.model.Client;

public interface ClientDAO extends JpaRepository<Client, Integer>{
	
	//public List<Bookings> findBy

}
