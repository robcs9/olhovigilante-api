package br.edu.ifpe.olhovigilanteapi.modelo.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Comentario, Long> {
    
}
