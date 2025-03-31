package com.Producer.Pvr.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id") 	
	private int bookingid;
	
	@ManyToOne
	@JoinColumn(name="movie_id", referencedColumnName = "movie_id")
	private Movie movie;

	@ManyToOne
	@JoinColumn(name="cinema_id")
	private Cinema cinema;
	
	@ManyToOne
	@JoinColumn(name="clint_id")
	private Clint clint;

	

	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public Clint getClint() {
		return clint;
	}

	public void setClint(Clint clint) {
		this.clint = clint;
	}

	@Override
	public String toString() {
		return "Booking [bookingid=" + bookingid + ", movie=" + movie + ", cinema=" + cinema + ", clint=" + clint + "]";
	}

	public Booking(Movie movie, Cinema cinema, Clint clint) {
		super();
		this.movie = movie;
		this.cinema = cinema;
		this.clint = clint;
	}
	
	public Booking() {}
	
}
