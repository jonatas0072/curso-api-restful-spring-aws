package com.springcurso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springcurso.domain.Request;
import com.springcurso.domain.enums.RequestState;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    @Transactional(readOnly = false)
    @Modifying
    @Query(value = "UPDATE Request SET state = ?2 WHERE id = ?1", nativeQuery = true)
    Request updateStatus(Long id, RequestState state);

    List<Request> findAllByUsuarioId(Long usuarioId);

}
