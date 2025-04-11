package br.com.crud.usuario.usuario;

import br.com.crud.usuario.exceptions.UsuarioNaoEncontradoException;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class DeletaUsarioController {

    private final UsuarioRepository usuarioRepository;

    public DeletaUsarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @DeleteMapping("usuario/{id}")
    @Transactional
    public void deleta(@PathVariable Long id){

        var usuario = usuarioRepository
                .findById(id)
                .orElseThrow(()-> new UsuarioNaoEncontradoException("Usuário não encontrado"));

        usuario.inativa();
    }
}
