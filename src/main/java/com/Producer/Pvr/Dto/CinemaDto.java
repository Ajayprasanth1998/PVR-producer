package com.Producer.Pvr.Dto;

import java.util.List;

import com.Producer.Pvr.Entity.Movie;

public class CinemaDto {
	private int cinemaid;
	private String name;
	private String location;
	private List<Integer> movieid;
	
	public int getCinemaid() {
		return cinemaid;
	}
	public void setCinemaid(int cinemaid) {
		this.cinemaid = cinemaid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Integer> getMovieid() {
		return movieid;
	}
	public void setMovieid(List<Integer> movieid) {
		this.movieid = movieid;
	}
	public CinemaDto(int cinemaid, String name, String location, List<Integer> movieid) {
		super();
		this.cinemaid = cinemaid;
		this.name = name;
		this.location = location;
		this.movieid = movieid;
	}
	@Override
	public String toString() {
		return "CinemaDto [cinemaid=" + cinemaid + ", name=" + name + ", location=" + location + ", movieid=" + movieid
				+ "]";
	}
	
}
