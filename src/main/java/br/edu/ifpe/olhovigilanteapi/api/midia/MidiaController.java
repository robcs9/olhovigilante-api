package br.edu.ifpe.olhovigilanteapi.api.midia;

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

import br.edu.ifpe.olhovigilanteapi.modelo.midia.Midia;
import br.edu.ifpe.olhovigilanteapi.modelo.midia.MidiaService;


@RestController
@RequestMapping("/api/midia")
@CrossOrigin
public class MidiaController {

    @Autowired
    private MidiaService midiaService;

    @PostMapping
    public ResponseEntity<Midia> save(@RequestBody MidiaRequest request) {
        
        Midia midia = midiaService.save(request.build());
        return new ResponseEntity<Midia>(midia, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Midia> findAll(MidiaRequest request) {
        List<Midia> midias = midiaService.findAll();
        return midias;
    }

    @GetMapping("/{id}")
    public Midia findById(@PathVariable("id") Long id) {
        Midia midia = midiaService.findById(id);
        return midia;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Midia> update(@PathVariable("id") Long id, @RequestBody MidiaRequest request) {
        
        midiaService.update(id, request.build());
        return ResponseEntity.ok().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Midia> delete(@PathVariable("id") Long id) {

        midiaService.delete(id);
        return ResponseEntity.ok().build();
    }
}
