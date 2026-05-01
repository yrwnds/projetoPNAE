package org.example.projetopnae.model.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    Usuario findByEmailAndSenha(String email, String senha);
    Usuario findById(long id);

}
