package com.Producer.Pvr.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="clint")
public class Clint {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="clint_id")
	private int clintid;
	
	@Column(name="user_name")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@OneToMany(mappedBy="clint")
	private List<Booking> booking;

	

	public int getClintid() {
		return clintid;
	}

	public void setClintid(int clintid) {
		this.clintid = clintid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}

	public Clint(String username, String password, List<Booking> booking) {
		super();
		this.username = username;
		this.password = password;
		this.booking = booking;
	}

	public Clint() {}

	@Override
	public String toString() {
		return "Clint [clintid=" + clintid + ", username=" + username + ", password=" + password + ", booking="
				+ booking + "]";
	}
	
}
