package br.edu.ifpe.olhovigilanteapi.modelo.midia;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MidiaService {

    @Autowired
    private MidiaRepository repository;

    @Transactional
    public Midia save(Midia midia) {

        midia.setHabilitado(Boolean.TRUE);
        midia.setVersao(1L);
        midia.setDataCriacao(LocalDate.now());
        return repository.save(midia);
    }
    
    public List<Midia> findAll() {
        return repository.findAll();
    }

    public Midia findById(Long id) {
        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Midia midiaAlterada) {

        Midia midia = repository.findById(id).get();
        midia.setMidiaUrl(midiaAlterada.getMidiaUrl());
        midia.setComentarioId(midiaAlterada.getComentarioId());
        midia.setOcorrenciaId(midiaAlterada.getOcorrenciaId());
        
        midia.setVersao(midia.getVersao() + 1);
        repository.save(midia);
    }

    @Transactional
    public void delete(Long id) {
        
        Midia midia = repository.findById(id).get();
        midia.setHabilitado(Boolean.FALSE);
        
        midia.setVersao(midia.getVersao() + 1);
        repository.save(midia);
    }

}
