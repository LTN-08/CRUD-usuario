package br.com.crud.usuario.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    boolean existsByemailOrCpf(String email, String cpf);

    Optional<Usuario> findById(Long id);

    Optional<Usuario> findByCpfAndNome(String cpf, String nome);

    Optional<Usuario> findAllById(Long id);
}
