package com.learning.travelmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.travelmanagement.model.Cab;

public interface CabDAO extends JpaRepository<Cab, Integer>{

}
