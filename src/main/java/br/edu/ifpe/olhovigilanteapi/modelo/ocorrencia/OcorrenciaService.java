package br.edu.ifpe.olhovigilanteapi.modelo.ocorrencia;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OcorrenciaService {

    @Autowired
    private OcorrenciaRepository repository;

    @Transactional
    public Ocorrencia save(Ocorrencia ocorrencia) {

        ocorrencia.setHabilitado(Boolean.TRUE);
        ocorrencia.setVersao(1L);
        ocorrencia.setDataCriacao(LocalDate.now());
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
        ocorrencia.setPresencaPolicial(ocorrenciaAlterada.getPresencaPolicial());
        ocorrencia.setAcaoPolicial(ocorrenciaAlterada.getAcaoPolicial());
        ocorrencia.setTipoOcorrencia(ocorrenciaAlterada.getTipoOcorrencia());
        ocorrencia.setMotivacao(ocorrenciaAlterada.getMotivacao());
        ocorrencia.setQtdVitimas(ocorrenciaAlterada.getQtdVitimas());
        
        
        ocorrencia.setVersao(ocorrencia.getVersao() + 1);
        repository.save(ocorrencia);
    }

    @Transactional
    public void delete(Long id) {
        
        Ocorrencia ocorrencia = repository.findById(id).get();
        ocorrencia.setHabilitado(Boolean.FALSE);
        
        ocorrencia.setVersao(ocorrencia.getVersao() + 1);
        repository.save(ocorrencia);
    }

}
