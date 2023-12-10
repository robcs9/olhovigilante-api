package br.edu.ifpe.olhovigilanteapi.modelo.acesso;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MembroRepository extends JpaRepository<Membro, Long> {
    
    Membro findByUsername(String username);

}
