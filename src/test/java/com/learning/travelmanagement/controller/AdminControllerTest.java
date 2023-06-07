package com.learning.travelmanagement.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*; 

import static org.mockito.BDDMockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.travelmanagement.dao.BookingsDAO;
import com.learning.travelmanagement.dao.CabDAO;
import com.learning.travelmanagement.dao.ClientDAO;
import com.learning.travelmanagement.model.Bookings;
import com.learning.travelmanagement.service.AdminServices;

//@RunWith(SpringRunner.class)
@WebMvcTest(AdminController.class)
class AdminControllerTest{
	@Autowired
	WebApplicationContext webApplicationContext;
	
	@MockBean
	private BookingsDAO bookingDao;
	@MockBean
	private CabDAO cabDao;
	@MockBean
	private ClientDAO clientDao;
	@MockBean
	private AdminServices adminService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void shouldGetAllBookings() throws Exception {
		List<Bookings> bookingList = new ArrayList<Bookings>();
		Bookings booking1 = new Bookings(1, "2", "08/07/2019", 150, 1, 1);
		Bookings booking2 = new Bookings(2, "2", "08/07/2019", 150, 1, 1);
		bookingList.add(booking2);
		bookingList.add(booking1);
        when(bookingDao.findAll()).thenReturn(bookingList);
		
		MvcResult mvcResult = mockMvc.perform(
			    get("/admin/bookings")).andReturn();
		
		String expected = "[{\"id\":2,\"noOfDays\":\"2\",\"date\":\"08/07/2019\",\"price\":150.0,\"cab\":{\"id\":1,\"cabModel\":null,\"cabType\":null,\"plateNo\":null,\"pricePerHour\":0},\"client\":{\"name\":null,\"address\":null,\"phone\":null,\"clientId\":1}},{\"id\":1,\"noOfDays\":\"2\",\"date\":\"08/07/2019\",\"price\":150.0,\"cab\":{\"id\":1,\"cabModel\":null,\"cabType\":null,\"plateNo\":null,\"pricePerHour\":0},\"client\":{\"name\":null,\"address\":null,\"phone\":null,\"clientId\":1}}]";
	    
		JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(), false);
	}
	
	@Test
	void shouldGetBookingById() throws Exception {
		//int id = 1;
        Bookings booking = new Bookings(1, "2", "08/07/2019", 150, 1, 1);
        when(bookingDao.findById(1)).thenReturn(Optional.of(booking));

        MvcResult mvcResult = mockMvc.perform(get("/admin/booking/{id}", 1)).andReturn();
        String expected = "{\"id\":1,\"noOfDays\":\"2\",\"date\":\"08/07/2019\",\"price\":150.0,\"cab\":{\"id\":1,\"cabModel\":null,\"cabType\":null,\"plateNo\":null,\"pricePerHour\":0},\"client\":{\"name\":null,\"address\":null,\"phone\":null,\"clientId\":1}}";
        
        JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(), true);
   
	}
	
	@Test
	void shouldPostBookings() throws Exception {
		Bookings bookings = new Bookings(1, "2", "08/07/2019", 150, 1, 1);
	
		given(bookingDao.save(bookings)).willReturn(bookings);
		//String expected = "{\"id\":1,\"noOfDays\":\"2\",\"date\":\"08/07/2019\",\"price\":150.0,\"cab\":{\"id\":1,\"cabModel\":null,\"cabType\":null,\"plateNo\":null,\"pricePerHour\":0},\"client\":{\"name\":null,\"address\":null,\"phone\":null,\"clientId\":1}}";
	    
		MvcResult res =  mockMvc.perform(
	          post("/admin/booking")
	            .content(new ObjectMapper().writeValueAsString(bookings))
              	.contentType(MediaType.APPLICATION_JSON)).andReturn();
        
		JSONAssert.assertEquals("200",String.valueOf(res.getResponse().getStatus()), false);
	}
	
	@Test
	void shouldUpdateBookingById() throws Exception {
		//int id = 1;
        Bookings booking = new Bookings(1, "2", "08/07/2019", 160, 2, 1);
        given(bookingDao.save(booking)).willReturn(booking);

        //String expected = "{\"id\":1,\"noOfDays\":\"2\",\"date\":\"08/07/2019\",\"price\":160.0,\"cab\":{\"id\":2,\"cabModel\":null,\"cabType\":null,\"plateNo\":null,\"pricePerHour\":0},\"client\":{\"name\":null,\"address\":null,\"phone\":null,\"clientId\":1}}";
        
        MvcResult res = mockMvc.perform(put("/admin/booking/{id}", 1)
        		.content(new ObjectMapper().writeValueAsString(booking))
              	.contentType(MediaType.APPLICATION_JSON))
        		.andDo(print()).andReturn();

        JSONAssert.assertEquals("200",String.valueOf(res.getResponse().getStatus()), false);
   
	}
	
	@Test
	void shouldDeleteBookingById() throws Exception {
		Integer id = 1;
        Bookings booking = new Bookings(id, "2", "08/07/2019", 150, 1, 1);
        doNothing().when(bookingDao).delete(booking);

        mockMvc.perform(delete("/admin/booking/{bookingId}", id)
	            .content(new ObjectMapper().writeValueAsString(booking))
              	.contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                		.andDo(print());
        
        //verify(bookingDao, times(1)).deleteById(id);
   
	}
	

}
