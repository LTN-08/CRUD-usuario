package br.com.crud.usuario.usuario;

import br.com.crud.usuario.exceptions.UsuarioNaoEncontradoException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuscaUsuarioController {

    private final UsuarioRepository usuarioRepository;

    public BuscaUsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("usuario/{id}")
    public UsuarioResponse busca(@PathVariable Long id) {

        return usuarioRepository
                .buscaUsuarioAtivoPorIdEFlagAtivo(id, "SIM")
                .map(UsuarioResponse::new)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(
                        "Usuario %s não encontrado no sistema!".formatted(id)));

    }
}
