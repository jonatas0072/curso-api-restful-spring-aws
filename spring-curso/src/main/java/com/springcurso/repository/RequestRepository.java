package com.springcurso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springcurso.domain.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    List<Request> findAllByUserId(Long id);

}
