package com.springcurso.repository;

import com.springcurso.domain.Request;
import com.springcurso.domain.RequestStage;
import com.springcurso.domain.Usuario;
import com.springcurso.domain.enums.Role;
import com.springcurso.service.UsuarioService;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UsuarioService service;

  @Test
  public void aSaveTest() {
    Usuario user =
            new Usuario(
                    1L,
                    "Jonatas",
                    "jonatas.macedo@idtrust.com.br",
                    "123",
                    Role.SIMPLE,
                    new ArrayList<Request>(),
                    new ArrayList<RequestStage>());

    Usuario createdUser = service.save(user);

    Usuario findById = userRepository.findById(createdUser.getId()).get();

    assertThat(createdUser.getId()).isEqualTo(findById.getId());
  }

  @Test
  public void bUpdateTest() {
    Usuario user =
            new Usuario(
                    1L,
                    "Jonatas Macedo",
                    "jonatas.macedo@idtrust.com.br",
                    "222",
                    Role.ADMINISTRATOR,
                    new ArrayList<Request>(),
                    new ArrayList<RequestStage>());
    Usuario updatedUser = service.update(user);

    assertThat(updatedUser.getName()).isEqualTo("Jonatas Macedo");
  }

  @Test
  public void cFindByIdTest() {
    Usuario result = service.findById(1L);

    Assert.assertEquals("Jonatas Macedo", result.getName());
  }

  @Test
  public void dListTest() {
    List<Usuario> users = userRepository.findAll();

    assertThat(users.size()).isEqualTo(1);
  }

  @Test
  public void eLoginTest() {
    Usuario result = service.login("jonatas.macedo@idtrust.com.br", "222");
    Usuario loggedUser = result;

    assertThat(loggedUser.getId()).isEqualTo(1L);
  }
}
