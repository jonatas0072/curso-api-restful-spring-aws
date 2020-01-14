package com.springcurso.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcurso.domain.Request;
import com.springcurso.domain.enums.RequestState;
import com.springcurso.exception.NotFoundException;
import com.springcurso.repository.RequestRepository;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    public Request save(Request request) {
        request.setState(RequestState.OPEN);
        request.setCriationDate(new Date());

        Request createdRequest = requestRepository.save(request);

        return createdRequest;

    }

    public Request update(Request request) {
        Request updateRequest = requestRepository.save(request);
        return updateRequest;

    }

    public Request findById(Long id) {
        Optional<Request> result = requestRepository.findById(id);
        return result.orElseThrow(() -> new NotFoundException(
                "Não a request com este ID = " + id));
    }

    public List<Request> listAll() {
        List<Request> requests = requestRepository.findAll();
        return requests;
    }

    public List<Request> listAllByOwnerId(Long id) {
        List<Request> requests = requestRepository.findAllByUserId(id);
        return requests;

    }

}
