package br.com.crud.usuario.usuario;

public class UsuarioResponse {

    private String nome;
    private String telefone;
    private String email;

    public UsuarioResponse( Usuario u){
        this.nome = u.getNome();
        this.telefone = u.getTelefone();
        this.email = u.getEmail();

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
}
