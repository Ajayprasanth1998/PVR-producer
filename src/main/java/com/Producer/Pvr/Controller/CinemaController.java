package com.Producer.Pvr.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Producer.Pvr.Dto.CinemaDto;
import com.Producer.Pvr.Entity.Cinema;
import com.Producer.Pvr.Service.CinemaService;

@RestController
@RequestMapping("/pvr/cinema")
public class CinemaController {

	@Autowired
	private CinemaService Cinemaservice;
	
	@GetMapping
	public List<CinemaDto> cinemaDto(){
		return Cinemaservice.getcinemadto();
	}
	
	@PostMapping
	public ResponseEntity<String> addCinema(@RequestBody Cinema cinema){
		return Cinemaservice.getAddCinema(cinema);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<String> UpdateCinema(@RequestBody Cinema cinema,@PathVariable("id") int cinemaid){
		return Cinemaservice.getUpdateCinema(cinema,cinemaid);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> DeleteCinema(@PathVariable("id") int cinemaid){
		return Cinemaservice.getDeleteDetails(cinemaid);
	}
	
	
}
