package com.Producer.Pvr.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Producer.Pvr.Entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer>{

}
