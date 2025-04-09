package br.com.crud.usuario.usuario;

import br.com.crud.usuario.exceptions.UsuarioJaCadastradoExceptions;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CadastraNovoUsuarioController {

    private final UsuarioRepository repository;

    public CadastraNovoUsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }


    @PostMapping("usuario")
    public String cria(@RequestBody @Valid NovoUsuarioResquest resquest){

        if (repository.existsByemailOrCpf(resquest.getEmail(), resquest.getCpf())){
            throw new UsuarioJaCadastradoExceptions(
                    "CPF ou EMAIL já cadastrado!");
        }

       var novoUsuario = resquest.resquestToEntity();
       repository.save(novoUsuario);

       return "Usuário criado com sucesso";

    }
}
