package com.springcurso.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.Optional;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springcurso.domain.Request;
import com.springcurso.domain.RequestStage;
import com.springcurso.domain.Usuario;
import com.springcurso.domain.enums.RequestState;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class ResquestStageRepositoryTests {
    @Autowired
    private RequestStageRepository requestStageRepository;

    @Test
    public void aSaveTest() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);

        Request request = new Request();
        request.setId(1L);

        RequestStage stage = new RequestStage(
                "Foi comprado um macbook de 125gb sdd", new Date(),
                RequestState.CLOSED, request, usuario);

        RequestStage createdStage = requestStageRepository.save(stage);

        assertThat(createdStage.getId()).isEqualTo(1L);
    }

    @Test
    public void fingByIdTest() {
        Optional<RequestStage> result = requestStageRepository.findById(1L);
        RequestStage stage = result.get();

        assertThat(stage.getDescription()).isEqualTo("Foi comprado um macbook de 125gb sdd");
    }

    // @Test
    // public void listByRequestIdTest() {
    // List<RequestStage> stages = requestStageRepository.findAllRequestId(1L);
    // assertThat(stages.size()).isEqualTo(1);
    // }
}
