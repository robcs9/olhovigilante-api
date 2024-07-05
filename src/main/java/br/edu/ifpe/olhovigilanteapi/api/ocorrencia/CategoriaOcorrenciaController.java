package br.edu.ifpe.olhovigilanteapi.api.ocorrencia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpe.olhovigilanteapi.modelo.ocorrencia.CategoriaOcorrencia;
import br.edu.ifpe.olhovigilanteapi.modelo.ocorrencia.CategoriaOcorrenciaService;
import br.edu.ifpe.olhovigilanteapi.modelo.ocorrencia.CategoriasEnum;

@RestController
@RequestMapping("/api/categoriaocorrencia")
@CrossOrigin
public class CategoriaOcorrenciaController {

    @Autowired
    CategoriaOcorrenciaService categoriaOcorrenciaService;

    @PostMapping
    public ResponseEntity<CategoriaOcorrencia> save(@RequestBody /* @Valid */ CategoriaOcorrenciaRequest request) {

        CategoriaOcorrencia novaCategoria = request.build();
        novaCategoria.setNome(request.getNome());
        CategoriaOcorrencia categoria = categoriaOcorrenciaService.save(novaCategoria);
        return new ResponseEntity<CategoriaOcorrencia>(categoria, HttpStatus.CREATED);
    }

    @GetMapping
    public List<CategoriaOcorrencia> findAll(CategoriaOcorrenciaRequest request) {
        
        
        List<CategoriaOcorrencia> categorias = categoriaOcorrenciaService.findAll();
        
        // Checa se a tabela de categorias está vazia
        if (categorias.isEmpty()) {
            this.populate();
        }

        return categorias;
    }

    @GetMapping("/{id}")
    public CategoriaOcorrencia findById(@PathVariable("id") Long id) {
        CategoriaOcorrencia categoria = categoriaOcorrenciaService.findById(id);
        return categoria;
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaOcorrencia> update(@PathVariable("id") Long id,
            @RequestBody CategoriaOcorrenciaRequest request) {

        CategoriaOcorrencia categoria = request.build();
        categoriaOcorrenciaService.update(id, categoria);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoriaOcorrencia> delete(@PathVariable("id") Long id) {

        categoriaOcorrenciaService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/populate")
    public ResponseEntity<CategoriaOcorrencia> populate(/* CategoriaOcorrenciaRequest request */) {
        List<CategoriaOcorrencia> categorias = new ArrayList<CategoriaOcorrencia>();

        for (CategoriasEnum categoriaEnum : CategoriasEnum.values()) {
            
            CategoriaOcorrencia categoria = new CategoriaOcorrencia();
            categoria.setNome(categoriaEnum.toString());
            categorias.add(categoria);
        }
        
        categoriaOcorrenciaService.saveAll(categorias);
        
        return ResponseEntity.ok().build();
    }
}
