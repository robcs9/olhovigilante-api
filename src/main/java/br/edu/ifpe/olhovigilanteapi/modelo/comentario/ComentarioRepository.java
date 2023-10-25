package br.edu.ifpe.olhovigilanteapi.modelo.comentario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
    
}
