package br.edu.ifpe.olhovigilanteapi.api.usuario;

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

import br.edu.ifpe.olhovigilanteapi.modelo.usuario.Midia;
import br.edu.ifpe.olhovigilanteapi.modelo.usuario.MidiaService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/usuario")
@CrossOrigin
public class UsuarioController {

    @Autowired
    private MidiaService usuarioService;

    @PostMapping
    public ResponseEntity<Midia> save(@RequestBody ComentarioRequest request) {
        
        Midia usuario = usuarioService.save(request.build());
        return new ResponseEntity<Midia>(usuario, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Midia> findAll(ComentarioRequest request) {
        List<Midia> usuarios = usuarioService.findAll();
        return usuarios;
    }

    @GetMapping("/{id}")
    public Midia findById(@PathVariable("id") Long id) {
        Midia usuario = usuarioService.findById(id);
        return usuario;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Midia> update(@PathVariable("id") Long id, @RequestBody ComentarioRequest request) {
        
        usuarioService.update(id, request.build());
        return ResponseEntity.ok().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Midia> delete(@PathVariable("id") Long id) {

        usuarioService.delete(id);
        return ResponseEntity.ok().build();
    }
}
