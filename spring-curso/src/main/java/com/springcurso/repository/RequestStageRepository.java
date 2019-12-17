package com.springcurso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestStageRepository extends JpaRepository<RequestStageRepository, Long>{

}
