package com.Producer.Pvr.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Producer.Pvr.Dto.CinemaDto;
import com.Producer.Pvr.Entity.Cinema;
import com.Producer.Pvr.Entity.Movie;
import com.Producer.Pvr.Repository.BookingRepository;
import com.Producer.Pvr.Repository.CinemaRepository;
import com.Producer.Pvr.Repository.MovieRepository;


@Service
public class CinemaService {

	@Autowired
	private CinemaRepository Cinemarepository;

	@Autowired
	private MovieRepository Movierepository; 
	
	@Autowired
	private BookingRepository Bookingrepository;
	
	public List<CinemaDto> getcinemadto() {
		List<Cinema> cinemas=Cinemarepository.findAll();
		
		return cinemas.stream().map(c-> new CinemaDto(
				c.getCinemaid(),
				c.getName(),
				c.getLocation(),
				c.getMovie().stream().map(m->m.getMovieid()).collect(Collectors.toList()))).collect(Collectors.toList());
	}


	public ResponseEntity<String> getAddCinema(Cinema cinema) {
		
		if(cinema.getMovie()!=null) {
			for(Movie movie:cinema.getMovie()) {
				movie.setCinema(cinema);
			}
		}	
		Cinemarepository.save(cinema);
		return ResponseEntity.ok("CINEMA ADDED SUCCESSFULLY");
	}


	
	public ResponseEntity<String> getUpdateCinema(Cinema cinema, int cinemaid) {
		
		return Cinemarepository.findById(cinemaid).map(existingCinema -> {
	        existingCinema.setName(cinema.getName());
	        existingCinema.setLocation(cinema.getLocation());

	        Optional.ofNullable(cinema.getMovie()).ifPresent(movies -> {
	            List<Movie> updatedMovies = movies.stream()
	                .map(movie -> Movierepository.findById(movie.getMovieid())
	                    .map(existingMovie -> {
	                        existingMovie.setTitle(movie.getTitle());
	                        existingMovie.setGenre(movie.getGenre());
	                        existingMovie.setDuration(movie.getDuration());
	                        existingMovie.setRating(movie.getRating());
	                        return existingMovie;
	                    })
	                    .orElseGet(() -> {
	                        movie.setCinema(existingCinema);
	                        return movie;
	                    }))
	                .collect(Collectors.toList());

	            existingCinema.setMovie(updatedMovies);
	        });

	        Cinemarepository.save(existingCinema);
	        return ResponseEntity.ok("CINEMA & MOVIE UPDATED SUCCESSFULLY");
	    }).orElse(ResponseEntity.status(404).body("CINEMA NOT FOUND"));
	
	}


	public ResponseEntity<String> getDeleteDetails(int cinemaid) {
		
		 return Cinemarepository.findById(cinemaid).map(cinema -> {
		        List<Movie> movies = cinema.getMovie();
		        
		        for (Movie movie : movies) {
		            Bookingrepository.deleteByMovieId(movie.getMovieid()); // Custom Query
		            Movierepository.deleteById(movie.getMovieid()); // Delete movie
		        }
		        Cinemarepository.delete(cinema);
		        
		        return ResponseEntity.ok("Cinema, Movies, and Bookings Deleted Successfully");
		    }).orElse(ResponseEntity.status(404).body("Cinema Not Found"));
		
	}

}
