package br.edu.ifpe.olhovigilanteapi.api.comentario;

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

import br.edu.ifpe.olhovigilanteapi.modelo.comentario.Comentario;
import br.edu.ifpe.olhovigilanteapi.modelo.comentario.ComentarioService;

@RestController
@RequestMapping("/api/comentario")
@CrossOrigin
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @PostMapping
    public ResponseEntity<Comentario> save(@RequestBody ComentarioRequest request) {
        
        Comentario comentario = comentarioService.save(request.build());
        return new ResponseEntity<Comentario>(comentario, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Comentario> findAll(ComentarioRequest request) {
        List<Comentario> comentarios = comentarioService.findAll();
        return comentarios;
    }

    @GetMapping("/{id}")
    public Comentario findById(@PathVariable("id") Long id) {
        Comentario comentario = comentarioService.findById(id);
        return comentario;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comentario> update(@PathVariable("id") Long id, @RequestBody ComentarioRequest request) {
        
        comentarioService.update(id, request.build());
        return ResponseEntity.ok().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Comentario> delete(@PathVariable("id") Long id) {

        comentarioService.delete(id);
        return ResponseEntity.ok().build();
    }
}
