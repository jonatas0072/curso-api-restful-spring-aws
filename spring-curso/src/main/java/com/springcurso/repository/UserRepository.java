package com.springcurso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springcurso.domain.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long>{
   
    
}
