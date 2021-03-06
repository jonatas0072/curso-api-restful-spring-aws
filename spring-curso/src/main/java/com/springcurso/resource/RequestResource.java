package com.springcurso.resource;

import com.springcurso.domain.Request;
import com.springcurso.domain.RequestStage;
import com.springcurso.dto.RequestDto;
import com.springcurso.model.PageModel;
import com.springcurso.model.PageRequestModel;
import com.springcurso.service.RequestService;
import com.springcurso.service.RequestStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "requests")
public class RequestResource {

  @Autowired
  private RequestService requestService;

  @Autowired
  private RequestStageService requestStageService;

  @PostMapping
  public ResponseEntity<Request> save(@RequestBody @Valid RequestDto requestDto) {
    Request request = requestDto.transformToRequest();

    Request createdRequest = requestService.save(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdRequest);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Request> update(
          @PathVariable(name = "id") Long id, @RequestBody @Valid RequestDto requestDto) {
    Request request = requestDto.transformToRequest();
    request.setId(id);

    Request updatedRequest = requestService.update(request);
    return ResponseEntity.ok(updatedRequest);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Request> getById(@PathVariable(name = "id") Long id) {
    Request request = requestService.findById(id);
    return ResponseEntity.ok(request);
  }

  @GetMapping
  public ResponseEntity<PageModel<Request>> listAll(
          @RequestParam(value = "page", defaultValue = "0") int page,
          @RequestParam(value = "size", defaultValue = "5") int size) {

    PageRequestModel prm = new PageRequestModel(page, size);
    PageModel<Request> pm = requestService.listAllOnLazyMode(prm);

    return ResponseEntity.ok(pm);
  }

  @GetMapping("/{id}/request-stages")
  public ResponseEntity<PageModel<RequestStage>> listtAllStageById(
          @PathVariable(name = "id") Long id,
          @RequestParam(value = "page", defaultValue = "0") int page,
          @RequestParam(value = "size", defaultValue = "5") int size) {
    PageRequestModel prm = new PageRequestModel(page, size);
    PageModel<RequestStage> pm = requestStageService.listAllByRequestIdOnLazy(id, prm);
    return ResponseEntity.ok(pm);
  }
}
