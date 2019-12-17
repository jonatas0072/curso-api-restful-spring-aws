package com.springcurso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestStage extends JpaRepository<RequestStage, Long>{

}
