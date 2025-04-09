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

    /**
     * @deprecated uso exclusivo do hibernate
     */
    @Deprecated
    public Usuario() {
    }


    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}

