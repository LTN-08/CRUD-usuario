package br.com.crud.usuario.compartilhado;

import br.com.crud.usuario.usuario.UsuarioJaCadastradoExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(UsuarioJaCadastradoExceptions.class)
    public ResponseEntity<?> usuarioJaCadastradoHandle(UsuarioJaCadastradoExceptions ex){
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
