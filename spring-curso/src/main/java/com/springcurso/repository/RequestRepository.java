package com.springcurso.repository;

import com.springcurso.domain.Request;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    Page<Request> findAllByUserId(Long id, Pageable pageable);

    List<Request> findAllByUserId(Long id);
}
