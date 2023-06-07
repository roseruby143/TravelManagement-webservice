package com.learning.travelmanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue
    @Column(name = "id")
    private int id;
	private String name;
	private String address;
	private String phone;
	
	/*
	 * @OneToMany(mappedBy = "client", fetch = FetchType.LAZY) private Set<Bookings>
	 * bookings = new HashSet<>();
	 */

	public Client(int id) {
		super();
		this.id = id;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getClientId() {
		return id;
	}

	public void setClientId(int clientId) {
		this.id = clientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	/*
	 * public Set<Bookings> getBooking() { return bookings; }
	 * 
	 * public void setBooking(Set<Bookings> booking) { this.bookings = booking; }
	 */

	@Override
	public String toString() {
		return "Client [clientId=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone
				+ "]";//, booking=" + bookings + "]";
	}
	
	
	
	
	
	
}
