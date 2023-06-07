package com.learning.travelmanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.travelmanagement.dao.BookingsDAO;
import com.learning.travelmanagement.model.Bookings;

@Service
public class ClientServices {
	
	@Autowired
	BookingsDAO bookingDao;

	public List<Bookings> getBookingsByClientId(int clientId) {
		// TODO Auto-generated method stub
		System.out.println("************** \nclientId is: "+clientId);
		List<Bookings> bData = new ArrayList<Bookings>();
		bookingDao.findByClientId(clientId).forEach(bData::add);
		System.out.println("*********** \nbData is: "+bData);
		return bData;
	}

	public Bookings addBookingByClientId(Bookings bData) {
		System.out.println("************** \n booking data is: "+bData);
		//List<Bookings> newData = new ArrayList<Bookings>();
		return bookingDao.save(bData);
	}
	
	public void deleteBookingByClientId(Bookings bookingData) {
		System.out.println("************** \n booking data is: "+bookingData);
		//List<Bookings> newData = new ArrayList<Bookings>();
		bookingDao.delete(bookingData);
	}
	
	public Bookings updateBookingByClientId(Bookings bData) {
		System.out.println("************** \n booking data is: "+bData);
		//List<Bookings> newData = new ArrayList<Bookings>();
		return bookingDao.save(bData);
	} 

}
