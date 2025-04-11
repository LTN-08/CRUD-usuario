package br.com.crud.usuario.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    boolean existsByemailOrCpf(String email, String cpf);

    Optional<Usuario> findById(Long id);

    Optional<Usuario> findByCpfAndNome(String cpf, String nome);

    Optional<Usuario> findAllById(Long id);

    @Query(value = "select u from Usuario u where u.id = :id and u.estaAtivo = :sim")
    Optional<Usuario> buscaUsuarioAtivoPorIdEFlagAtivo(Long id, String sim);
}
