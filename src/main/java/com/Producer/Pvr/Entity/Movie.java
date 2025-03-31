package com.Producer.Pvr.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="movie")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="movie_id")
	private int movieid;
	
	@Column(name="title")
	private String title;
	
	@Column(name="genre")
	private String genre;
	
	@Column(name="duration")
	private String duration;
	
	@Column(name="rating")
	private String rating;
	
	@ManyToOne
	@JoinColumn(name="cinema_id")
	private Cinema cinema;
	
	@ElementCollection
	private List<String> showtime;

	public int getMovieid() {
		return movieid;
	}

	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public List<String> getShowtime() {
		return showtime;
	}

	public void setShowtime(List<String> showtime) {
		this.showtime = showtime;
	}

	@Override
	public String toString() {
		return "Movie [movieid=" + movieid + ", title=" + title + ", genre=" + genre + ", duration=" + duration
				+ ", rating=" + rating + ", cinema=" + cinema + ", showtime=" + showtime + "]";
	}

	public Movie() {}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public Movie(String title, String genre, String duration, String rating, Cinema cinema,
			List<String> showtime) {
		super();
		this.title = title;
		this.genre = genre;
		this.duration = duration;
		this.rating = rating;
		this.cinema = cinema;
		this.showtime = showtime;
	}
}
