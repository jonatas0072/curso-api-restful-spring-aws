package com.springcurso.resource;

import com.springcurso.domain.RequestStage;
import com.springcurso.dto.RequestStageDto;
import com.springcurso.service.RequestStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "request-stages")
public class RequestStageResource {

    @Autowired
    private RequestStageService requestStageService;

    @PostMapping
    public ResponseEntity<RequestStage> save(@Valid @RequestBody RequestStageDto requestStageDto) {
        RequestStage requestStage = requestStageDto.transformToRequestStage();
        RequestStage createdRequestStage = requestStageService.save(requestStage);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRequestStage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestStage> getById(@PathVariable(name = "id") Long id) {
        RequestStage stage = requestStageService.findById(id);
        return ResponseEntity.ok(stage);
    }
}
