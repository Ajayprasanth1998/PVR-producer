package com.Producer.Pvr.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="cinema")
public class Cinema {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cinema_id")
	private int cinemaid;
	
	@Column(name="name")
	private String name;
	
	@Column(name="location")
	private String location;
	
	@OneToMany(mappedBy="cinema",fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Movie> movie;

	

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

	@Override
	public String toString() {
		return "Cinema [cinemaid=" + cinemaid + ", name=" + name + ", location=" + location + ", movie=" + movie + "]";
	}
	
	public List<Movie> getMovie() {
		return movie;
	}

	public void setMovie(List<Movie> movie) {
		this.movie = movie;
	}

	public Cinema(String name, String location, List<Movie> movie) {
		super();
		this.name = name;
		this.location = location;
		this.movie = movie;
	}

	public Cinema() {}
}
