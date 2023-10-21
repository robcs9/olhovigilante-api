package br.edu.ifpe.olhovigilanteapi.api.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpe.olhovigilanteapi.modelo.usuario.Usuario;
import br.edu.ifpe.olhovigilanteapi.modelo.usuario.UsuarioService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/usuario")
@CrossOrigin
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody UsuarioRequest request) {

        Usuario usuario = usuarioService.save(request.build());
        return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Usuario> findAll(UsuarioRequest request) {
        List<Usuario> usuarios = usuarioService.findAll();
        return usuarios;
    }

    @GetMapping("/{id}")
    public Usuario findById(@PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);
        return usuario;
    }
    
}
