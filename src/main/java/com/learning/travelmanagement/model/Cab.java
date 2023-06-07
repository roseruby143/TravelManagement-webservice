package com.learning.travelmanagement.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cab")
public class Cab {
	
	
	@Id
	@GeneratedValue
    @Column(name = "id")
	private Integer id;
	
	private String cabModel;
	private String cabType;
	private String plateNo;
	private int pricePerHour;
	
	/*
	 * @OneToMany(mappedBy = "cab", fetch = FetchType.LAZY) private Set<Bookings>
	 * bookings = new HashSet<>();
	 */

	public Cab(Integer id) {
		super();
		this.id = id;
	}
	
	public Cab() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer cabId) {
		this.id = cabId;
	}

	public String getCabModel() {
		return cabModel;
	}

	public void setCabModel(String cabModel) {
		this.cabModel = cabModel;
	}

	public String getCabType() {
		return cabType;
	}

	public void setCabType(String cabType) {
		this.cabType = cabType;
	}

	public String getPlateNo() {
		return plateNo;
	}

	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}

	public Integer getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(Integer pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	/*
	 * public Set<Bookings> getBookings() { return bookings; }
	 * 
	 * public void setBookings(Set<Bookings> bookings) { this.bookings = bookings; }
	 */

	@Override
	public String toString() {
		return "Cab [cabId=" + id + ", cabModel=" + cabModel + ", cabType=" + cabType + ", plateNo=" + plateNo
				+ ", pricePerHour=" + pricePerHour + "]";//, bookings=" + bookings + "]";
	}
	
	
}
