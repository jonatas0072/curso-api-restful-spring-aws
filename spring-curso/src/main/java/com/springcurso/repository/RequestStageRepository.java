package com.springcurso.repository;

import com.springcurso.domain.RequestStage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestStageRepository extends JpaRepository<RequestStage, Long> {

    List<RequestStage> findAllByRequestId(long id);

    Page<RequestStage> findAllByRequestId(Long requestId, Pageable pageable);
}
