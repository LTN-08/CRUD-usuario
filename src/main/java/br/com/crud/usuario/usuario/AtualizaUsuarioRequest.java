package br.com.crud.usuario.usuario;

import jakarta.validation.constraints.NotNull;

import java.util.Objects;


public class AtualizaUsuarioRequest {

    @NotNull
    private Long id;
    private String nome;
    private String email;
    private String telefone;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return "AtualizaUsuarioRequest{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }

    public boolean emailNaoNulo() {
        return Objects.nonNull(this.email);
    }

    public boolean nomeNaoNulo() {
        return Objects.nonNull(this.nome);
    }

    public boolean telefoneNaoNulo() {
        return Objects.nonNull(this.telefone);
    }
}

