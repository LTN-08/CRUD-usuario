package br.com.crud.usuario.usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;


public class NovoUsuarioResquest {

    @NotBlank
    private String nome;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Length(min = 11, max = 11)
    @CPF(message = "CPF INVÁLIDO!")
    private String cpf;
    @NotBlank
    private String senha;
    @NotBlank
    @Length(min = 11, max = 11)
    private String telefone;

    public Usuario resquestToEntity() {
        return new Usuario(nome, email,cpf, senha, telefone);
    }

    public boolean nomeNulo() {
        return this.nome == null || this.nome.equals("");
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public String getTelefone() {
        return telefone;
    }
}
