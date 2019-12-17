package com.springcurso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springcurso.domain.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long>{
    
    
}
