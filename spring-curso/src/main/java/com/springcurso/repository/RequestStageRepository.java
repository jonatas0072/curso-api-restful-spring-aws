package com.springcurso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springcurso.domain.Request;
import com.springcurso.domain.RequestStage;

@Repository
public interface RequestStageRepository
        extends JpaRepository<RequestStageRepository, Long> {

        public List<RequestStage> findAllByRequestId(Long Id);
        
        @Query("UPDATE Request SET state = ?2 WHERE id = ?1")
        public Request updateStatus(Long id, RequestStage state);
}
