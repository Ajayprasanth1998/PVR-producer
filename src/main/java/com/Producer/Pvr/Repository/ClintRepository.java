package com.Producer.Pvr.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Producer.Pvr.Entity.Clint;

@Repository
public interface ClintRepository extends JpaRepository<Clint,Integer>{

}
