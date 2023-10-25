package br.edu.ifpe.olhovigilanteapi.modelo.seguidor;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeguidorService {

    @Autowired
    private SeguidorRepository repository;

    @Transactional
    public Seguidor save(Seguidor seguidor) {

        seguidor.setHabilitado(Boolean.TRUE);
        seguidor.setVersao(1L);
        seguidor.setDataCriacao(LocalDate.now());
        return repository.save(seguidor);
    }
    
    public List<Seguidor> findAll() {
        return repository.findAll();
    }

    public Seguidor findById(Long id) {
        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Seguidor seguidorAlterado) {

        Seguidor seguidor = repository.findById(id).get();
        seguidor.setUsuarioSeguidorId(seguidorAlterado.getUsuarioSeguidorId());
        seguidor.setUsuarioSeguidoId(seguidorAlterado.getUsuarioSeguidoId());
        
        seguidor.setVersao(seguidor.getVersao() + 1);
        repository.save(seguidor);
    }

    @Transactional
    public void delete(Long id) {
        
        Seguidor seguidor = repository.findById(id).get();
        seguidor.setHabilitado(Boolean.FALSE);
        
        seguidor.setVersao(seguidor.getVersao() + 1);
        repository.save(seguidor);
    }

}
