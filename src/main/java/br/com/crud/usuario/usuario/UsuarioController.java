package br.com.crud.usuario.usuario;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    private final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }


    @PostMapping
    public String cria(@RequestBody @Valid NovoUsuarioResquest resquest){

        if (resquest.nomeNulo()){
            throw new DadosNuloException("Nome é obrigatório!");
        }

        if (repository.existsByemailOrCpf(resquest.getEmail(), resquest.getCpf())){

            throw new UsuarioJaCadastradoExceptions(
                    "CPF ou EMAIL já cadastrado!");
        }

       var novoUsuario = resquest.resquestToEntity();

       repository.save(novoUsuario);

       return "Criado com sucesso";

    }
}
