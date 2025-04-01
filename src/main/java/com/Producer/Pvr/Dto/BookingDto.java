package com.Producer.Pvr.Dto;

import com.Producer.Pvr.Entity.Cinema;
import com.Producer.Pvr.Entity.Clint;
import com.Producer.Pvr.Entity.Movie;

public class BookingDto {

	private int bookingid;
	private int movieid;
	private int cinemaid;
	private int clintid;
	
	public int getBookingid() {
		return bookingid;
	}
	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}
	public int getMovieid() {
		return movieid;
	}
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	public int getCinemaid() {
		return cinemaid;
	}
	public void setCinemaid(int cinemaid) {
		this.cinemaid = cinemaid;
	}
	public int getClintid() {
		return clintid;
	}
	public void setClintid(int clintid) {
		this.clintid = clintid;
	}
	@Override
	public String toString() {
		return "BookingDto [bookingid=" + bookingid + ", movieid=" + movieid + ", cinemaid=" + cinemaid + ", clintid="
				+ clintid + "]";
	}
	public BookingDto(int bookingid, int movieid, int cinemaid, int clintid) {
		super();
		this.bookingid = bookingid;
		this.movieid = movieid;
		this.cinemaid = cinemaid;
		this.clintid = clintid;
	}
	
}
