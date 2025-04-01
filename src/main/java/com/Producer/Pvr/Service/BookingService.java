package com.Producer.Pvr.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Producer.Pvr.Dto.BookingDto;
import com.Producer.Pvr.Entity.Booking;
import com.Producer.Pvr.Entity.Cinema;
import com.Producer.Pvr.Entity.Clint;
import com.Producer.Pvr.Entity.Movie;
import com.Producer.Pvr.Repository.BookingRepository;
import com.Producer.Pvr.Repository.CinemaRepository;
import com.Producer.Pvr.Repository.ClintRepository;
import com.Producer.Pvr.Repository.MovieRepository;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingreppo;
	
	@Autowired
	private MovieRepository moviereppo;
	
	@Autowired
	private CinemaRepository cinemareppo;
	
	@Autowired
	private ClintRepository clintreppo;
	
	public List<BookingDto> getBookings() {
		return bookingreppo.findAll().stream().map(b->new BookingDto(
				b.getBookingid(),b.getMovie().getMovieid(),b.getCinema().getCinemaid(),b.getClint().getClintid())).toList();
	}
	
	public ResponseEntity<?> getBooking(int id) {
		Optional<Booking> book=bookingreppo.findById(id);
		if(book.isPresent()) {
		return ResponseEntity.ok(book.get().getBookingid()+" Id Booked Movie "+book.get().getMovie().getTitle()+" and Cinema is "+
																				book.get().getCinema().getName());
		}
		return ResponseEntity.status(404).body("Booking Id Not Found");
	}
	
	public ResponseEntity<?> getAddBooking(BookingDto dto) {
		
		Optional<Movie> movie=moviereppo.findById(dto.getMovieid());
		Optional<Cinema> cinema=cinemareppo.findById(dto.getCinemaid());
		Optional<Clint> clint=clintreppo.findById(dto.getClintid());
		
		if(movie.isPresent() && cinema.isPresent() && clint.isPresent()) {	
			Booking book=new Booking(movie.get(),cinema.get(),clint.get());
			bookingreppo.save(book);
			return ResponseEntity.ok("Booking Added Successfully");
		}
		return ResponseEntity.status(404).body("Booking, Movie or Cinema or Clint is Not Found");
	}

	
	
	public ResponseEntity<?> deleteBooking(int id) {
		
		Optional<Booking> optbook=bookingreppo.findById(id);
		
		if(!optbook.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking id is not found");
		}
		Booking book=optbook.get();
		int clintid=book.getClint().getClintid();
		
		bookingreppo.delete(book);		
		
		Optional<Clint> clint=clintreppo.findById(clintid);
		if(clint.isPresent()) {
			clintreppo.deleteById(clintid);
		}
		return ResponseEntity.ok("Booking Deleted Successfully");
	}

	
	
	
	
	
}
