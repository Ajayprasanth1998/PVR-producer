package com.Producer.Pvr.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Producer.Pvr.Dto.MovieDto;
import com.Producer.Pvr.Service.MovieService;


@RestController
@RequestMapping("/pvr/movie")
public class MovieController {

	@Autowired
	private MovieService movieservice;
	
	
	//http://localhost:8080/pvr/movie
	@GetMapping
	public List<MovieDto> movies(){
		return movieservice.getMovies();
	}

	//http://localhost:8080/pvr/movie/1
	@GetMapping("{id}")
	public ResponseEntity<?> movie(@PathVariable int id){
		return movieservice.getMovie(id);
	}
	
	
	@PostMapping
	public ResponseEntity<?> addMovie(@RequestBody MovieDto moviedto){
		return movieservice.getAddMovie(moviedto);
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<?> updatemovie(@PathVariable int id,@RequestBody MovieDto dto){
		return movieservice.getUpdateMovie(id,dto);
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> DeleteMovie(@PathVariable int id){
		return movieservice.getDeleteMovie(id);
	}
	
	
	
}
