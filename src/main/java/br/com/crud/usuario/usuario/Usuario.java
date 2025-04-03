package br.com.crud.usuario.usuario;

import jakarta.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String nome;
    @Column(nullable = false, length = 50, unique = true)
    private String email;
    @Column(nullable = false, length = 11, unique = true)
    private String cpf;
    @Column(nullable = false, length = 50)
    private String senha;
    @Column(nullable = false, length = 11, unique = true)
    private String telefone;

    public Usuario(String nome, String email, String cpf, String senha, String telefone) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
        this.telefone = telefone;
    }
}

