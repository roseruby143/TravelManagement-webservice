package com.learning.travelmanagement.controller;

import java.util.List;
import java.util.Optional;

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

import com.learning.travelmanagement.dao.BookingsDAO;
import com.learning.travelmanagement.dao.CabDAO;
import com.learning.travelmanagement.dao.ClientDAO;
import com.learning.travelmanagement.model.Bookings;
import com.learning.travelmanagement.model.Cab;
import com.learning.travelmanagement.model.Client;
import com.learning.travelmanagement.service.AdminServices;

/*
 * when admin looks into all bookings -> /bookings . GET
 * when admin edits booking -> /booking/{boookingId} [data in request body]. PUT
 * when admin creates a bookings -> /bookings/{bookingId}. POST
 * when admin cancels booking -> booking/{bookingId}. DELETE
 * 
 * */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/admin/")
public class AdminController {
	/*
	 * @Autowired private BookingsDAO bookingDao;
	 */
	
	@Autowired
	private AdminServices adminService;
	
	@Autowired BookingsDAO bookingDao;
	@Autowired CabDAO cabDao;
	@Autowired ClientDAO clientDao;
	
	/************ ADMIN BOOKINGS CONTROLLER ************/
	@GetMapping("/bookings")
	@ResponseBody
	public List<Bookings> getBookings() {
		List<Bookings> bookingList = bookingDao.findAll();
		System.out.println("****** \nThe booking list is : "+bookingList);
		
		return bookingList;
	}
	
	@GetMapping("/cab/{cabId}/bookings")
	@ResponseBody
	public List<Bookings> getBookingsbyCabId(@PathVariable int cabId) {
		List<Bookings> bookingList = adminService.getBookingsByCabId(cabId);
		System.out.println("****** \nThe booking list is : "+bookingList);
		
		return bookingList;
	}
	
	@GetMapping("/booking/{bookingId}")
	@ResponseBody
	public Optional<Bookings> getBookingsbyId(@PathVariable int bookingId) {
		Optional<Bookings> bookingList = bookingDao.findById(bookingId);
		System.out.println("****** \nThe booking list is : "+bookingList);
		
		return bookingList;
	}
	
	@PostMapping("/booking")
	@ResponseBody
	public Bookings newBooking(@RequestBody Bookings bData) {
		/*
		 * bData.setClient(new Client(clientId)); bData.setCab(new Cab(cabId));
		 */
		System.out.println("****** \nThe booking data is : "+bData);
		return bookingDao.save(bData);
	}
	
	@PutMapping("/booking/{bookingId}")
	@ResponseBody
	public Bookings updateBooking(@RequestBody Bookings bData, @PathVariable int bookingId) {
		System.out.println("The request Body data is: "+bData);
		bData.setId(bookingId);
		/*
		 * bData.setClient(new Client(clientId)); bData.setCab(new Cab(cabId));
		 */
		System.out.println("****** \nThe booking data is : "+bData);
		return bookingDao.save(bData);
	}
	
	@DeleteMapping("/booking/{bookingId}")
	@ResponseBody
	public boolean deleteBooking(@RequestBody Bookings bData) {
		try{
			System.out.println("****** \nThe booking data is : "+bData);
			bookingDao.delete(bData);
			return true;
		}catch(Exception e) {
			System.out.println("Error deleyting booking data : "+e.getMessage());
			e.printStackTrace();
			return false;
		}
		
		/*
		 * System.out.println("****** \nThe booking list is : "+bookingList);
		 * 
		 * return bookingList;
		 */
	}
	
	/******** ADMIN CABS CONTROLLER***********/
	
	@GetMapping("/cabs")
	@ResponseBody
	public List<Cab> getCabs() {
		List<Cab> cabList = cabDao.findAll();
		System.out.println("****** \nThe Cab list is : "+cabList);
		
		return cabList;
	}
	
	@GetMapping("/cab/{id}")
	@ResponseBody
	public Optional<Cab> getCabsById(@PathVariable("id") int id) {
		Optional<Cab> cabList = cabDao.findById(id);
		System.out.println("****** \nThe Cab list is : "+cabList);
		return cabList;
	}
	
	@PostMapping("/cab")
	@ResponseBody
	public Cab newCab(@RequestBody Cab cData) {
		/*
		 * bData.setClient(new Client(clientId)); bData.setCab(new Cab(cabId));
		 */
		System.out.println("****** \nThe Cab data is : "+cData);
		return cabDao.save(cData);
	}
	
	@PutMapping("/cab/{cabId}")
	@ResponseBody
	public Cab updateCab(@RequestBody Cab cData, @PathVariable int cabId) {
		cData.setId(cabId);
		/*
		 * bData.setClient(new Client(clientId)); bData.setCab(new Cab(cabId));
		 */
		System.out.println("****** \nThe Cab data is : "+cData);
		return cabDao.save(cData);
	}
	
	@DeleteMapping("/cab/{cabId}")
	@ResponseBody
	public void deleteCab(@RequestBody Cab cData) {
		System.out.println("****** \nThe Cab data is : "+cData);
		cabDao.delete(cData);
		/*
		 * System.out.println("****** \nThe booking list is : "+bookingList);
		 * 
		 * return bookingList;
		 */
	}
	
/******** ADMIN CLIENT CONTROLLER***********/
	
	@GetMapping("/clients")
	@ResponseBody
	public List<Client> getClients() {
		List<Client> clientList = clientDao.findAll();
		System.out.println("****** \nThe Cab list is : "+clientList);
		
		return clientList;
	}
	
	@GetMapping("/client/{id}")
	@ResponseBody
	public Optional<Client> getClientById(@PathVariable("id") int id) {
		Optional<Client> clientList = clientDao.findById(id);
		System.out.println("****** \nThe Cab list is : "+clientList);
		return clientList;
	}
	
	@PostMapping("/client")
	@ResponseBody
	public Client newClient(@RequestBody Client cData) {
		/*
		 * bData.setClient(new Client(clientId)); bData.setCab(new Cab(cabId));
		 */
		System.out.println("****** \nThe Cab data is : "+cData);
		return clientDao.save(cData);
	}
	
	@PutMapping("/client/{clientId}")
	@ResponseBody
	public Client updateClient(@RequestBody Client cData, @PathVariable int clientId) {
		cData.setClientId(clientId);
		/*
		 * bData.setClient(new Client(clientId)); bData.setCab(new Cab(cabId));
		 */
		System.out.println("****** \nThe Cab data is : "+cData);
		return clientDao.save(cData);
	}
	
	@DeleteMapping("/client/{clientId}")
	@ResponseBody
	public void deleteClient(@RequestBody Client cData) {
		System.out.println("****** \nThe Cab data is : "+cData);
		clientDao.delete(cData);
		/*
		 * System.out.println("****** \nThe booking list is : "+bookingList);
		 * 
		 * return bookingList;
		 */
	}
	
}
