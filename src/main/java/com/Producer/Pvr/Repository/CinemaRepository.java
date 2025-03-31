package com.Producer.Pvr.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Producer.Pvr.Entity.Cinema;


@Repository
public interface CinemaRepository extends JpaRepository<Cinema,Integer>{

}
