package com.springcurso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springcurso.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
