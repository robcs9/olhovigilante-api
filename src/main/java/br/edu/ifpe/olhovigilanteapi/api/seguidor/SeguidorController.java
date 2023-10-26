package br.edu.ifpe.olhovigilanteapi.api.seguidor;

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

import br.edu.ifpe.olhovigilanteapi.modelo.seguidor.Seguidor;
import br.edu.ifpe.olhovigilanteapi.modelo.seguidor.SeguidorService;


@RestController
@RequestMapping("/api/seguidor")
@CrossOrigin
public class SeguidorController {

    @Autowired
    private SeguidorService seguidorService;

    @PostMapping
    public ResponseEntity<Seguidor> save(@RequestBody SeguidorRequest request) {
        
        Seguidor seguidor = seguidorService.save(request.build());
        return new ResponseEntity<Seguidor>(seguidor, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Seguidor> findAll(SeguidorRequest request) {
        List<Seguidor> seguidores = seguidorService.findAll();
        return seguidores;
    }

    @GetMapping("/{id}")
    public Seguidor findById(@PathVariable("id") Long id) {
        Seguidor seguidor = seguidorService.findById(id);
        return seguidor;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Seguidor> update(@PathVariable("id") Long id, @RequestBody SeguidorRequest request) {
        
        seguidorService.update(id, request.build());
        return ResponseEntity.ok().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Seguidor> delete(@PathVariable("id") Long id) {

        seguidorService.delete(id);
        return ResponseEntity.ok().build();
    }
}
