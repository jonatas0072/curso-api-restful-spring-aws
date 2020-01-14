package com.springcurso.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcurso.domain.RequestStage;
import com.springcurso.domain.enums.RequestState;
import com.springcurso.exception.NotFoundException;
import com.springcurso.repository.RequestRepository;
import com.springcurso.repository.RequestStageRepository;

@Service
public class RequestStageService {

    @Autowired
    private RequestStageRepository requestStageRepository;

    @Autowired
    private RequestRepository requestRepository;

    public RequestStage save(RequestStage stage) {
        stage.setRealizationDate(new Date());

        RequestStage createdStage = requestStageRepository.save(stage);
        RequestState state = stage.getState();

        createdStage.setState(state);
        requestRepository.save(createdStage.getRequest());
        requestStageRepository.save(createdStage);
        return createdStage;
    }

    public RequestStage findById(Long id) {
        Optional<RequestStage> result = requestStageRepository.findById(id);
        return result.orElseThrow(() -> new NotFoundException(
                "Não a request-stage com este ID = " + id));
    }

    public List<RequestStage> listAllByRequestId(Long requestId) {
        List<RequestStage> stages = requestStageRepository
                .findAllByRequestId(requestId);
        return stages;
    }
}
