package br.edu.ifpe.olhovigilanteapi.modelo.ocorrencia;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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

    @Transactional
    public List<CategoriaOcorrencia> saveAll(List<CategoriaOcorrencia> categorias) {

        for (CategoriaOcorrencia categoria : categorias) {

            categoria.setHabilitado(Boolean.TRUE);
            categoria.setVersao(1L);
            categoria.setDataCriacao(LocalDate.now());
        }

        return repository.saveAll(categorias);
    }

    public List<CategoriaOcorrencia> findAll() {
        List<CategoriaOcorrencia> categorias = repository.findAll();

        return categorias;
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
