package com.springcurso.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springcurso.domain.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT * FROM usuario pu WHERE pu.email = ?1 AND pu.password = ?2", nativeQuery = true)
    Optional<Usuario> login(String email, String password);
 
    
}
