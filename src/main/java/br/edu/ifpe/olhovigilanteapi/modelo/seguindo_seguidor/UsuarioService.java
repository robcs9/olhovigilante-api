package br.edu.ifpe.olhovigilanteapi.modelo.usuario;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private ComentarioRepository repository;

    @Transactional
    public Comentario save(Comentario usuario) {

        usuario.setHabilitado(Boolean.TRUE);
        usuario.setVersao(1L);
        usuario.setDataCriacao(LocalDate.now());
        return repository.save(usuario);
    }
    
    public List<Comentario> findAll() {
        return repository.findAll();
    }

    public Comentario findById(Long id) {
        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Comentario usuarioAlterado) {

        Comentario usuario = repository.findById(id).get();
        usuario.setNome(usuarioAlterado.getNome());
        usuario.setCpf(usuarioAlterado.getCpf());
        usuario.setEmail(usuarioAlterado.getEmail());
        usuario.setSenha(usuarioAlterado.getSenha());
        usuario.setBairro(usuarioAlterado.getBairro());
        usuario.setCidade(usuarioAlterado.getCidade());
        usuario.setAvatar(usuarioAlterado.getAvatar());
        usuario.setRole(usuarioAlterado.getRole());
        usuario.setReputacao(usuarioAlterado.getReputacao());
        usuario.setVerificado(usuarioAlterado.getVerificado());
        usuario.setContadorSeguidores(usuarioAlterado.getContadorSeguidores());
        usuario.setContadorSeguindo(usuarioAlterado.getContadorSeguindo());
        
        usuario.setVersao(usuario.getVersao() + 1);
        repository.save(usuario);
    }

    @Transactional
    public void delete(Long id) {
        
        Comentario usuario = repository.findById(id).get();
        usuario.setHabilitado(Boolean.FALSE);
        
        usuario.setVersao(usuario.getVersao() + 1);
        repository.save(usuario);
    }

}
