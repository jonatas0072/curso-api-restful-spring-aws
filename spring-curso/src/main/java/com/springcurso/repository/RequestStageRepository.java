package com.springcurso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springcurso.domain.Request;
import com.springcurso.domain.RequestStage;
import com.springcurso.domain.enums.RequestState;

@Repository
public interface RequestStageRepository
        extends JpaRepository<RequestStageRepository, Long> {

        public List<RequestStage> findAllByRequestId(Long Id);
        
}
