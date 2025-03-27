package com.usuario.controller;

import com.usuario.model.Usuario;
import com.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }

    @PostMapping("/salvar")
    public Usuario salvar(@RequestBody Usuario usuario) {
      try {
        return service.salvar(usuario);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Erro ao salvar usuário: possível duplicação de email ou problema com os dados.");
        } catch (Exception e) {
            throw new RuntimeException("Erro interno ao salvar usuário.");
        }
    }
}
