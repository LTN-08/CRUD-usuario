package br.com.crud.usuario.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping
    public String olaApi(){
        return "Hello Word";

    }
}
