package br.com.crud.usuario.usuario;

import br.com.crud.usuario.exceptions.UsuarioNaoEncontradoException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.Optional;

@RestController
public class AtualizaUsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PutMapping("usuario")
    @Transactional
    public void atualiza(@RequestBody @Valid AtualizaUsuarioRequest request){

        var usuario = usuarioRepository
                .findAllById(request.getId())
                .orElseThrow(() ->
                        new UsuarioNaoEncontradoException("Usuário ID " + request.getId()+ " não encontrado"));


        if (request.emailNaoNulo()) {
                usuario.setEmail(request.getEmail());
        }

        if (request.nomeNaoNulo()){
            usuario.setNome(request.getNome());
        }

        if (request.telefoneNaoNulo()){
            usuario.setTelefone(request.getTelefone());
        }
    }
}
