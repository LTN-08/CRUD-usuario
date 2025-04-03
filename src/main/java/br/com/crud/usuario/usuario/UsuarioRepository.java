package br.com.crud.usuario.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    boolean existsByemailOrCpf(String email, String cpf);

}
