package br.edu.ifpe.olhovigilanteapi.api.ocorrencia;

import java.util.List;

import javax.validation.Valid;

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

import br.edu.ifpe.olhovigilanteapi.modelo.ocorrencia.CategoriaOcorrenciaService;
import br.edu.ifpe.olhovigilanteapi.modelo.ocorrencia.Ocorrencia;
import br.edu.ifpe.olhovigilanteapi.modelo.ocorrencia.OcorrenciaService;
import br.edu.ifpe.olhovigilanteapi.modelo.usuario.UsuarioService;


@RestController
@RequestMapping("/api/ocorrencia")
@CrossOrigin
public class OcorrenciaController {

    @Autowired
    private OcorrenciaService ocorrenciaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CategoriaOcorrenciaService categoriaOcorrenciaService;

    @PostMapping
    public ResponseEntity<Ocorrencia> save(@RequestBody /* @Valid */ OcorrenciaRequest request) {
        
        Ocorrencia novaOcorrencia = request.build();
        novaOcorrencia.setUsuario(usuarioService.findById(request.getUsuarioId()));
        novaOcorrencia.setCategoria(categoriaOcorrenciaService.findById(request.getCategoriaId()));
        Ocorrencia ocorrencia = ocorrenciaService.save(novaOcorrencia);
        return new ResponseEntity<Ocorrencia>(ocorrencia, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Ocorrencia> findAll(OcorrenciaRequest request) {
        List<Ocorrencia> ocorrencias = ocorrenciaService.findAll();
        return ocorrencias;
    }

    @GetMapping("/{id}")
    public Ocorrencia findById(@PathVariable("id") Long id) {
        Ocorrencia ocorrencia = ocorrenciaService.findById(id);
        return ocorrencia;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ocorrencia> update(@PathVariable("id") Long id, @RequestBody OcorrenciaRequest request) {
        
        Ocorrencia ocorrencia = request.build();
        //ocorrencia.setUsuario(usuarioService.findById(request.getUsuarioId()));
        //ocorrencia.setCategoria(categoriaOcorrenciaService.findById(request.getCategoriaId())); // conrrigir o problema de id nulo caso inclua isto no request
        ocorrenciaService.update(id, ocorrencia);
        return ResponseEntity.ok().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Ocorrencia> delete(@PathVariable("id") Long id) {

        ocorrenciaService.delete(id);
        return ResponseEntity.ok().build();
    }

    //http://localhost:8082/api/ocorrencia/{id}?upvote
    @PutMapping("/{id}/upvote")
    public ResponseEntity<Ocorrencia> upvote(@PathVariable("id") Long id) {
        
        ocorrenciaService.upvote(id);
        return ResponseEntity.ok().build();
    }

    //http://localhost:8082/api/ocorrencia/{id}?downvote
    @PutMapping("/{id}/downvote")
    public ResponseEntity<Ocorrencia> downvote(@PathVariable("id") Long id) {
        
        ocorrenciaService.downvote(id);
        return ResponseEntity.ok().build();
    }
}
