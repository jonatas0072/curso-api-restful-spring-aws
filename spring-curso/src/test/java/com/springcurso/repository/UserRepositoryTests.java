package com.springcurso.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
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
import com.springcurso.domain.enums.Role;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void aSaveTest() {
        Usuario user = new Usuario(1L, "Jonatas",
                "jonatas.macedo@idtrust.com.br", "123", Role.ADMINISTRATOR,
                new ArrayList<Request>(), new ArrayList<RequestStage>());

        Usuario createdUser = userRepository.save(user);

        Usuario findById = userRepository.findById(createdUser.getId()).get();

        assertThat(createdUser.getId()).isEqualTo(findById.getId());
    }

    @Test
    public void bUpdateTest() {
        Usuario user = new Usuario(1L, "Jonatas Macedo",
                "jonatas.macedo@idtrust.com.br", "3245678", Role.ADMINISTRATOR,
                new ArrayList<Request>(), new ArrayList<RequestStage>());
        Usuario updatedUser = userRepository.saveAndFlush(user);

        assertThat(updatedUser.getName()).isEqualTo("Jonatas Macedo");
    }

    @Test
    public void cFindByIdTest() {
        Optional<Usuario> result = userRepository.findById(1L);
        Usuario user = result.get();

        assertThat(user.getPassword()).isEqualTo("3245678");

    }

    @Test
    public void dListTest() {
        List<Usuario> users = userRepository.findAll();

        assertThat(users.size()).isEqualTo(1);
    }

    @Test
    public void eLoginTest() {
        Optional<Usuario> result = userRepository
                .login("jonatas.macedo@idtrust.com.br", "3245678");

        Optional<Usuario> findById = userRepository
                .findById(result.get().getId());
        assertEquals(result.get().getId(), findById.get().getId());
    }
    
}
