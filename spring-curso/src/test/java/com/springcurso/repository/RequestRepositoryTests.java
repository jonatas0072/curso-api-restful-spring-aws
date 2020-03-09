package com.springcurso.repository;

import com.springcurso.domain.Request;
import com.springcurso.domain.Usuario;
import com.springcurso.domain.enums.RequestState;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class RequestRepositoryTests {

  @Autowired
  private RequestRepository requestRepository;

  @Test
  public void aSaveTest() {
    Usuario usuario = new Usuario();
    usuario.setId(1L);

    Request request =
            new Request(
                    "MacBook pro 15",
                    "Descrição: notebook apple",
                    new Date(),
                    RequestState.OPEN,
                    usuario,
                    null);

    Request createdRequest = requestRepository.save(request);

    assertThat(createdRequest.getId()).isEqualTo(1L);
  }

  @Test
  public void bUpdateTest() {
    Usuario usuario = new Usuario();
    usuario.setId(1L);

    Request request =
            new Request(
                    1L,
                    "MacBook pro 13",
                    "Descrição: MacBook Pro 13 the Jonatas Idtrustian",
                    null,
                    RequestState.OPEN,
                    usuario,
                    null);

    Request updateRequest = requestRepository.save(request);

    assertThat(updateRequest.getDescription())
            .isEqualTo("Descrição: MacBook Pro 13 the Jonatas Idtrustian");
  }

  @Test
  public void cFindByIdTest() {
    Optional<Request> result = requestRepository.findById(1L);
    Request request = result.get();

    assertThat(request.getSubject()).isEqualTo("MacBook pro 13");
  }

  @Test
  public void dListTest() {
    List<Request> requests = requestRepository.findAll();

    assertThat(requests.size()).isEqualTo(1);
  }

  @Test
  public void eListByUsuarioIdTest() {
    Optional<Request> requests = requestRepository.findById(1L);
    assertThat(requests.get().getUser().getId()).isEqualTo(1);
  }

  // public void fUpdateStatusTest() {
  // Usuario usuario = new Usuario();
  // usuario.setId(1L);
  // Request request = new Request(1L, RequestState.IN_PROGRESS, usuario);
  //
  // Request updateRequest = requestRepository.save(request);
  //
  // assertThat(updateRequest.getState()).isEqualTo(RequestState.CLOSED);
  // }
}
