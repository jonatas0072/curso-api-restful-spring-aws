package com.springcurso.repository;

import com.springcurso.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {

    @Query(
            value = "SELECT * FROM usuario pu WHERE pu.email = ? AND pu.password = ?",
            nativeQuery = true)
    Optional<Usuario> login(String email, String password);
}
