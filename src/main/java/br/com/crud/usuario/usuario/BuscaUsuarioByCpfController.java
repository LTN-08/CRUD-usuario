package br.com.crud.usuario.usuario;

import br.com.crud.usuario.exceptions.UsuarioNaoEncontradoException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuscaUsuarioByCpfController {

    private final UsuarioRepository usuarioRepository;

    public BuscaUsuarioByCpfController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("usuario")
    public UsuarioResponse getUsuarioByCpf(@RequestParam("cpf") String cpf,
                                           @RequestParam("nome") String nome){

     var  possivelUsuario = usuarioRepository.findByCpfAndNome(cpf, nome);

     if (possivelUsuario.isEmpty()){
         throw new UsuarioNaoEncontradoException("Usuário não encontrado por CPF %s " .formatted(cpf));

     }
        var usuario = possivelUsuario.get();

        return new UsuarioResponse(usuario);
    }
}
