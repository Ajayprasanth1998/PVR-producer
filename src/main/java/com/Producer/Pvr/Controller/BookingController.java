package com.Producer.Pvr.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Producer.Pvr.Dto.BookingDto;
import com.Producer.Pvr.Service.BookingService;


@RestController
@RequestMapping("/pvr/booking")
public class BookingController {

	@Autowired
	private BookingService bookingservice;
	
	
	//http://localhost:8080/pvr/booking
	@GetMapping()
	public List<BookingDto> bookings(){
		return bookingservice.getBookings();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> booking(@PathVariable int id){
		return bookingservice.getBooking(id);
	}
	
	
	@PostMapping()
	public ResponseEntity<?> addBooking(@RequestBody BookingDto dto){
		return bookingservice.getAddBooking(dto);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteBooking(@PathVariable int id){
		return bookingservice.deleteBooking(id);
	}
	
}
