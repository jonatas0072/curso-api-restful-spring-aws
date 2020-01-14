package com.springcurso.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springcurso.domain.Request;
import com.springcurso.domain.Usuario;
import com.springcurso.dto.UsuarioLoginDto;
import com.springcurso.model.PageModel;
import com.springcurso.model.PageRequestModel;
import com.springcurso.service.RequestService;
import com.springcurso.service.UsuarioService;

@RestController
@RequestMapping(value = "users")
public class UserResource {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RequestService requestService;

    @PostMapping()
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) {
        Usuario creadedUsuario = usuarioService.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(creadedUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable(name = "id") Long id,
            @RequestBody Usuario usuario) {
        usuario.setId(id);
        Usuario updateUsuario = usuarioService.update(usuario);
        return ResponseEntity.ok(updateUsuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable(name = "id") Long id) {
        Usuario usuario = usuarioService.findById(id);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity<PageModel<Usuario>> listAll(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size) {

        PageRequestModel prm = new PageRequestModel(page, size);
        PageModel<Usuario> pm = usuarioService.listAllOnLazyMode(prm);

        return ResponseEntity.ok(pm);
    }

    @GetMapping("/{id}/requests")
    public ResponseEntity<PageModel<Request>> listAllRequestById(
            @PathVariable(name = "id") Long id,
            @RequestParam(value = "size") int size,
            @RequestParam(value = "page") int page) {
        PageRequestModel prm = new PageRequestModel(page, size);
        PageModel<Request> pm = requestService.listAllByOwnerIdOnLazy(id, prm);

        return ResponseEntity.ok(pm);
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(
            @RequestBody UsuarioLoginDto usuarioLogin) {
        Usuario loggedUsuario = usuarioService.login(usuarioLogin.getEmail(),
                usuarioLogin.getPassword());
        return ResponseEntity.ok(loggedUsuario);

    }

}
