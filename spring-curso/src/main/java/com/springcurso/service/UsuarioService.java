package com.springcurso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springcurso.domain.Usuario;
import com.springcurso.exception.NotFoundException;
import com.springcurso.model.PageModel;
import com.springcurso.model.PageRequestModel;
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

    public Usuario update(Usuario usuario) {
        String hash = HashUtil.getSecureHash(usuario.getPassword());
        usuario.setPassword(hash);

        Usuario updatedUser = userRepository.saveAndFlush(usuario);
        return updatedUser;
    }

    public Usuario findById(Long id) {
        Optional<Usuario> result = userRepository.findById(id);
        return result.orElseThrow(() -> new NotFoundException(
                "Não a usuario com este ID = " + id));
    }

    public List<Usuario> listAll() {
        List<Usuario> usuarios = userRepository.findAll();
        return usuarios;
    }

    public PageModel<Usuario> listAllOnLazyMode(PageRequestModel prm) {
        Pageable pageable = PageRequest.of(prm.getPage(), prm.getSize());
        Page<Usuario> page = userRepository.findAll(pageable);
        
        PageModel<Usuario> pm = new PageModel<Usuario>((int)page.getTotalElements(), page.getSize(), page.getTotalPages(), page.getContent());
        
        return pm;
    }

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
