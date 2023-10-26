package br.edu.ifpe.olhovigilanteapi.api.ocorrencia;

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

import br.edu.ifpe.olhovigilanteapi.modelo.ocorrencia.Ocorrencia;
import br.edu.ifpe.olhovigilanteapi.modelo.ocorrencia.OcorrenciaService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/ocorrencia")
@CrossOrigin
public class OcorrenciaController {

    @Autowired
    private OcorrenciaService ocorrenciaService;

    @PostMapping
    public ResponseEntity<Ocorrencia> save(@RequestBody OcorrenciaRequest request) {
        
        Ocorrencia ocorrencia = ocorrenciaService.save(request.build());
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
        
        ocorrenciaService.update(id, request.build());
        return ResponseEntity.ok().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Ocorrencia> delete(@PathVariable("id") Long id) {

        ocorrenciaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
