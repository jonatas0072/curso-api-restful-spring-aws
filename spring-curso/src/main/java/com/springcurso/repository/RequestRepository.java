package com.springcurso.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springcurso.domain.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    Page<Request> findAllByUserId(Long id, Pageable pageable);

    List<Request> findAllByUserId(Long id);

}
