package com.Producer.Pvr.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.Producer.Pvr.Entity.Booking;

import jakarta.transaction.Transactional;


@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer>{
	@Transactional
	@Modifying
	@Query("DELETE FROM Booking b WHERE b.movie.movieid = :movieid")
	void deleteByMovieId(@Param("movieid") int movieid);
}
