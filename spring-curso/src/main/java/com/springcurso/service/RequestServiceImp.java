package com.springcurso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcurso.domain.Request;
import com.springcurso.repository.RequestRepository;

@Service
public class RequestServiceImp{

    @Autowired 
    private RequestRepository requestRepository;
    
    public Request update(Request request) {
        Request updatedRequest = requestRepository.save(request);
        return updatedRequest;
}

}
