package br.edu.ifpe.olhovigilanteapi.modelo.ocorrencia;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

public class CategoriaOcorrenciaService {
    
    @Autowired
    private CategoriaOcorrenciaRepository repository;

    @Transactional
    public CategoriaOcorrencia save(CategoriaOcorrencia categoriaOcorrencia) {
        
        categoriaOcorrencia.setHabilitado(Boolean.TRUE);
        categoriaOcorrencia.setVersao(1L);
        categoriaOcorrencia.setDataCriacao(LocalDate.now());
        return repository.save(categoriaOcorrencia);
    }

    public List<CategoriaOcorrencia> findAll() {

        return repository.findAll();
    }

    public CategoriaOcorrencia findById(Long id) {

        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, CategoriaOcorrencia categoriaOcorrenciaAlterado) {

        CategoriaOcorrencia categoria = repository.findById(id).get();
        categoria.setNome(categoriaOcorrenciaAlterado.getNome());
        
        categoria.setVersao(categoria.getVersao() + 1);
        repository.save(categoria);
    }

    @Transactional
    public void delete(Long id) {

        CategoriaOcorrencia categoria = repository.findById(id).get();
        categoria.setHabilitado(Boolean.FALSE);
        categoria.setVersao(categoria.getVersao() + 1);

        repository.save(categoria);
    }
}
