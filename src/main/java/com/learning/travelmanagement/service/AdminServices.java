package com.learning.travelmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.travelmanagement.dao.BookingsDAO;
import com.learning.travelmanagement.model.Bookings;

@Service
public class AdminServices {
	
	@Autowired BookingsDAO bookingDao;
	
	public List<Bookings> getBookingsByCabId(int cabId) {
		// TODO Auto-generated method stub
		//System.out.println("************** \nclientId is: "+cabId);
		List<Bookings> bData = new ArrayList<Bookings>();
		bookingDao.findByCabId(cabId).forEach(bData::add);
		//System.out.println("*********** \nbData is: "+bData);
		return bData;
	}

}
