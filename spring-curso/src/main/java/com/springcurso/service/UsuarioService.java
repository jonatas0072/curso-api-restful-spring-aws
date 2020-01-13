package com.springcurso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcurso.domain.Usuario;
import com.springcurso.repository.UserRepository;
import com.springcurso.service.util.HashUtil;

@Service
public class UsuarioService {

    @Autowired
    private UserRepository userRepository;

    public Usuario save(Usuario usuario) {
        String hash = HashUtil.getSecureHash(usuario.getPassword());
        usuario.setPassword(hash);
        Usuario createdUsuario = userRepository.save(usuario);
        return createdUsuario;
    }

    // update
    public Usuario update(Usuario usuario) {
        String hash = HashUtil.getSecureHash(usuario.getPassword());
        usuario.setPassword(hash);

        Usuario updatedUser = userRepository.saveAndFlush(usuario);
        return updatedUser;
    }

    // get
    public Usuario findById(Long id) {
        Optional<Usuario> result = userRepository.findById(id);
        return result.get();
    }

    // list
    public List<Usuario> listAll() {
        List<Usuario> usuarios = userRepository.findAll();
        return usuarios;
    }

    // login
    public Usuario login(String email, String password) {
        String password_hash = HashUtil.getSecureHash(password);

        Optional<Usuario> result = userRepository.login(email, password_hash);
        if (result.isPresent())
            System.out.println("Usuario Encontrado");
        else
            System.out.println("Usuario Nao Encontrado");
        return result.get();

    }
}
