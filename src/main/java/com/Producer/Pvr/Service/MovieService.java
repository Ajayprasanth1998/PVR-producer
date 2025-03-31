package com.Producer.Pvr.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Producer.Pvr.Dto.MovieDto;
import com.Producer.Pvr.Entity.Cinema;
import com.Producer.Pvr.Entity.Movie;
import com.Producer.Pvr.Repository.BookingRepository;
import com.Producer.Pvr.Repository.CinemaRepository;
import com.Producer.Pvr.Repository.MovieRepository;


@Service
public class MovieService {

	@Autowired
	private MovieRepository moviereppo;
	
	@Autowired
	private CinemaRepository cinemareppo;
	
	@Autowired
	private BookingRepository bookingreppo;
	
	public List<MovieDto> getMovies() {	
		return moviereppo.findAll().stream().map(m->
			new MovieDto(m.getMovieid(),m.getTitle(),m.getGenre(),m.getDuration(),m.getRating(),
				m.getCinema().getCinemaid(),m.getShowtime())).collect(Collectors.toList());
	}

	
	public ResponseEntity<?> getMovie(int id) {
		Optional<Movie> m=moviereppo.findById(id);
		
		if(m.isPresent()) {
			Movie m1=moviereppo.findById(id).get();
			
			MovieDto mdt=new MovieDto(m1.getMovieid(),
										m1.getTitle(),m1.getGenre(),m1.getDuration(),m1.getRating(),
										m1.getCinema().getCinemaid(),m1.getShowtime());
			
			return ResponseEntity.ok(mdt);
		}
		
		return ResponseEntity.status(404).body("Movie Not Found");
	}

	
	
	

	public ResponseEntity<?> getAddMovie(MovieDto dto) {
		
		Cinema cinema=cinemareppo.findById(dto.getCinemaid()).get();
		Movie movie=new Movie(dto.getTitle(),dto.getGenre(),dto.getDuration(),dto.getRating(),cinema,
				dto.getShowtime());
		moviereppo.save(movie);
		
		return ResponseEntity.ok("Movie Added Successfully");
	}


	public ResponseEntity<?> getUpdateMovie(int id, MovieDto dto) {
		
		Cinema cinema=cinemareppo.findById(dto.getCinemaid()).get();
		Movie movie=moviereppo.findById(id).get();
		movie.setTitle(dto.getTitle());
		movie.setGenre(dto.getGenre());
		movie.setDuration(dto.getDuration());
		movie.setRating(dto.getRating());
		movie.setCinema(cinema);
		movie.setShowtime(dto.getShowtime());
		
		moviereppo.save(movie);
		return ResponseEntity.ok("Movie Updated Successfully");
	}


	public ResponseEntity<?> getDeleteMovie(int id) {
		
		Optional<Movie> movie=moviereppo.findById(id);
		if(movie.isPresent()) {
			
			bookingreppo.deleteById(movie.get().getMovieid());
			moviereppo.delete(movie.get());
			return ResponseEntity.ok("Movie Deleted Succesfully");
		}
		return ResponseEntity.status(404).body("Movie Not FOUND");
	}
}
