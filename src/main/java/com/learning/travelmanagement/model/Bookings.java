package com.learning.travelmanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookings")
public class Bookings {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
    private int id;
	
	/*
	 * private Integer cabId; private int clientId;
	 */
	
	private String noOfDays;
	private String date;
	private float price;
	
	@OneToOne
	private Cab cab;
	@OneToOne
	private Client client;

	public Bookings(int id, String noOfDays, String date, float price, int cabId, int clientId) {
		super();
		this.id = id;
		this.noOfDays = noOfDays;
		this.date = date;
		this.price = price;
		this.cab = new Cab(cabId);
		this.client = new Client(clientId);
	}
	
	public Bookings() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(String noOfDays) {
		this.noOfDays = noOfDays;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Cab getCab() {
		return cab;
	}

	public void setCab(Cab cab) {
		this.cab = cab;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Bookings [id=" + id + ", noOfDays=" + noOfDays + ", date=" + date + ", price="
				+ price + ", cab=" + cab + ", client=" + client + "]";
	}

	
	
}
