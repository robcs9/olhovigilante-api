package br.edu.ifpe.olhovigilanteapi.modelo.ocorrencia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import br.edu.ifpe.olhovigilanteapi.modelo.midia.Midia;

@Service
public class OcorrenciaService /* extends GenericService  */{

    @Autowired
    private OcorrenciaRepository repository;

    @Autowired
    private CategoriaOcorrenciaRepository categoriaOcorrenciaRepository;

    @Transactional
    public Ocorrencia save(Ocorrencia ocorrencia) {

        
        ocorrencia.setHabilitado(Boolean.TRUE);
        ocorrencia.setVersao(1L);
        ocorrencia.setDataCriacao(LocalDate.now());
        //ocorrencia.setCriadoPor(ocorrencia.getUsuario().getId()); // interpretação incorreta do propósito
        ocorrencia.setAvaliacao(0);
        return repository.save(ocorrencia);
    }
    
    public List<Ocorrencia> findAll() {
        return repository.findAll();
    }

    public Ocorrencia findById(Long id) {
        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Ocorrencia ocorrenciaAlterada) {

        Ocorrencia ocorrencia = repository.findById(id).get();
        ocorrencia.setAvaliacao(ocorrenciaAlterada.getAvaliacao());
        ocorrencia.setCidade(ocorrenciaAlterada.getCidade());
        ocorrencia.setBairro(ocorrenciaAlterada.getBairro());
        ocorrencia.setGeolocalizacao(ocorrenciaAlterada.getGeolocalizacao());
        ocorrencia.setDataHoraOcorrencia(ocorrenciaAlterada.getDataHoraOcorrencia());
        // ocorrencia.setPresencaPolicial(ocorrenciaAlterada.getPresencaPolicial());
        // ocorrencia.setAcaoPolicial(ocorrenciaAlterada.getAcaoPolicial());
        // ocorrencia.setMotivacao(ocorrenciaAlterada.getMotivacao());
        // ocorrencia.setQtdVitimas(ocorrenciaAlterada.getQtdVitimas());
        
        ocorrencia.setDataUltimaModificacao(LocalDate.now());
        ocorrencia.setVersao(ocorrencia.getVersao() + 1);
        repository.save(ocorrencia);
    }

    @Transactional
    public void delete(Long id) {
        
        Ocorrencia ocorrencia = repository.findById(id).get();
        ocorrencia.setHabilitado(Boolean.FALSE);
        ocorrencia.setDataUltimaModificacao(LocalDate.now());
        ocorrencia.setVersao(ocorrencia.getVersao() + 1);
        repository.save(ocorrencia);
    }

    @Transactional
    public void upvote(Long id) {
        
        Ocorrencia ocorrencia = repository.findById(id).get();
        ocorrencia.setAvaliacao(ocorrencia.getAvaliacao() + 1);

        ocorrencia.setDataUltimaModificacao(LocalDate.now());
        ocorrencia.setVersao(ocorrencia.getVersao() + 1);
        repository.save(ocorrencia);
    }
    
    @Transactional
    public void downvote(Long id) {
        
        Ocorrencia ocorrencia = repository.findById(id).get();
        ocorrencia.setAvaliacao(ocorrencia.getAvaliacao() - 1);

        ocorrencia.setDataUltimaModificacao(LocalDate.now());
        ocorrencia.setVersao(ocorrencia.getVersao() + 1);
        repository.save(ocorrencia);
    }

    /* public List<Midia> findMidias() {
        List<Midia> midias = midiaRepository.findAll();
        for(Midia midia : midias) {
            if(midia.getOcorrenciaId())
        }
    } */

    /* @Query(value = "SELECT * FROM midia WHERE midia.ocorrenciaId = 42")
    public List<Midia> finMidias() {
        List<Midia> midias = new ArrayList<>();
        return midias; 
    } */
}
