package com.Producer.Pvr.Dto;

import java.util.List;

public class ClintDto {
	
	private int clintid;
	private String username;
	private List<Integer> bookingIds;
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
	public List<Integer> getBookingIds() {
		return bookingIds;
	}
	public void setBookingIds(List<Integer> bookingIds) {
		this.bookingIds = bookingIds;
	}
	@Override
	public String toString() {
		return "ClintDto [clintid=" + clintid + ", username=" + username + ", bookingIds=" + bookingIds + "]";
	}
	public ClintDto(int clintid, String username, List<Integer> bookingIds) {
		super();
		this.clintid = clintid;
		this.username = username;
		this.bookingIds = bookingIds;
	}
	
}
