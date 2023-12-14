package br.edu.ifpe.olhovigilanteapi.modelo.ocorrencia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.ifpe.olhovigilanteapi.modelo.midia.Midia;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {
    
    /* @Query(value = "SELECT * FROM midia WHERE midia.ocorrenciaId = 42")
    public List<Midia> findMidias(); */
}
