package br.com.crud.usuario.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BuscaTodosUsuariosController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("usuarios")
    public List<UsuarioResponse> buscaTodos(){

        return usuarioRepository
                .findAll()
                .stream()
                .map(UsuarioResponse::new)
                .toList();

    }
}
