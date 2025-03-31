package com.Producer.Pvr.Dto;

import com.Producer.Pvr.Entity.Cinema;
import com.Producer.Pvr.Entity.Clint;
import com.Producer.Pvr.Entity.Movie;

public class BookingDto {

	private int bookingid;
	private Movie movieid;
	private Cinema cinemaid;
	private Clint clintid;
	
	public int getBookingid() {
		return bookingid;
	}
	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}
	public Movie getMovieid() {
		return movieid;
	}
	public void setMovieid(Movie movieid) {
		this.movieid = movieid;
	}
	public Cinema getCinemaid() {
		return cinemaid;
	}
	public void setCinemaid(Cinema cinemaid) {
		this.cinemaid = cinemaid;
	}
	public Clint getClintid() {
		return clintid;
	}
	public void setClintid(Clint clintid) {
		this.clintid = clintid;
	}
	@Override
	public String toString() {
		return "BookingDto [bookingid=" + bookingid + ", movieid=" + movieid + ", cinemaid=" + cinemaid + ", clintid="
				+ clintid + "]";
	}
	public BookingDto(int bookingid, Movie movieid, Cinema cinemaid, Clint clintid) {
		super();
		this.bookingid = bookingid;
		this.movieid = movieid;
		this.cinemaid = cinemaid;
		this.clintid = clintid;
	}
	
}
