package br.edu.ifpe.olhovigilanteapi.modelo.comentario;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository repository;

    @Transactional
    public Comentario save(Comentario comentario) {

        comentario.setHabilitado(Boolean.TRUE);
        comentario.setVersao(1L);
        comentario.setDataCriacao(LocalDate.now());
        return repository.save(comentario);
    }
    
    public List<Comentario> findAll() {
        return repository.findAll();
    }

    public Comentario findById(Long id) {
        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Comentario comentarioAlterado) {

        Comentario comentario = repository.findById(id).get();
        comentario.setTexto(comentarioAlterado.getTexto());
        comentario.setAvaliacao(comentarioAlterado.getAvaliacao());
        comentario.setOcorrenciaId(comentarioAlterado.getOcorrenciaId());
        
        comentario.setVersao(comentario.getVersao() + 1);
        repository.save(comentario);
    }

    @Transactional
    public void delete(Long id) {
        
        Comentario comentario = repository.findById(id).get();
        comentario.setHabilitado(Boolean.FALSE);
        
        comentario.setVersao(comentario.getVersao() + 1);
        repository.save(comentario);
    }

}
