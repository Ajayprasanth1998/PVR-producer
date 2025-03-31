package com.Producer.Pvr.Dto;

import java.util.List;

public class MovieDto {
	
	private int movieid;
	private String title;
	private String genre;
	private String duration;
	private String rating;
	private int cinemaid;
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
	public int getCinemaid() {
		return cinemaid;
	}
	public void setCinemaid(int cinemaid) {
		this.cinemaid = cinemaid;
	}
	public List<String> getShowtime() {
		return showtime;
	}
	public void setShowtime(List<String> showtime) {
		this.showtime = showtime;
	}
	@Override
	public String toString() {
		return "MovieDto [movieid=" + movieid + ", title=" + title + ", genre=" + genre + ", duration=" + duration
				+ ", rating=" + rating + ", cinemaid=" + cinemaid + ", showtime=" + showtime + "]";
	}
	public MovieDto(int movieid, String title, String genre, String duration, String rating, int cinemaid,
			List<String> showtime) {
		super();
		this.movieid = movieid;
		this.title = title;
		this.genre = genre;
		this.duration = duration;
		this.rating = rating;
		this.cinemaid = cinemaid;
		this.showtime = showtime;
	}
	
}
