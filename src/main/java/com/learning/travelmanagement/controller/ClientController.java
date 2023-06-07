package com.learning.travelmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.travelmanagement.model.Bookings;
import com.learning.travelmanagement.model.Client;
import com.learning.travelmanagement.service.ClientServices;

/*
 * when client makes booking -> client/{clientId}/booking/{cabId} [data in request body]. POST
 * when client edits booking -> client/{clientId}/booking/{cabId} [data in request body]. PUT
 * when client fetches all bookings -> client/{clientId}/bookings. GET
 * when client cancels booking -> client/{clientId}/booking/{bookingId}. DELETE
 * 
 * */


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/client/{clientId}")
public class ClientController {
	
	@Autowired
	private ClientServices clientService;
	
	
	
	/************ CLIENT CONTROLLER ************/
	@GetMapping("/bookings")
	@ResponseBody
	public List<Bookings> getBookings(@PathVariable int clientId) {
		List<Bookings> bookingList = clientService.getBookingsByClientId(clientId);
		System.out.println("****** \nThe booking list is : "+bookingList);
		
		return bookingList;
	}
	
	@PostMapping("/booking")
	@ResponseBody
	public Bookings newBooking(@RequestBody Bookings bData) {
		bData.setClient(new Client(bData.getClient().getClientId()));
		
		System.out.println("****** \nThe booking data is : "+bData);
		Bookings returnObj = clientService.addBookingByClientId(bData);
		System.out.println("** Client save returnObj: +"+returnObj);
		return returnObj;
	}
	
	@PutMapping("/booking/{bookingId}")
	@ResponseBody
	public Bookings updateBooking(@RequestBody Bookings bData, @PathVariable int bookingId) {
		bData.setId(bookingId);
		/*
		 * bData.setClient(new Client(clientId)); bData.setCab(new Cab(cabId));
		 */
		System.out.println("****** \nThe booking data is : "+bData);
		return clientService.updateBookingByClientId(bData);
	}
	
	@DeleteMapping("/booking/{bookingId}")
	@ResponseBody
	public void deleteBooking(@RequestBody Bookings bData) {
		System.out.println("****** \nThe booking data is : "+bData);
		clientService.deleteBookingByClientId(bData);
		/*
		 * System.out.println("****** \nThe booking list is : "+bookingList);
		 * 
		 * return bookingList;
		 */
	}

}
