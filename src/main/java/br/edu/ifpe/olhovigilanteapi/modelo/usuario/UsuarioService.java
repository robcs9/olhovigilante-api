package br.edu.ifpe.olhovigilanteapi.modelo.usuario;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpe.olhovigilanteapi.modelo.acesso.MembroService;

@Service
public class UsuarioService {
    
    @Autowired
    private MembroService membroService;

    @Autowired
    private UsuarioRepository repository;

    @Transactional
    public Usuario save(Usuario usuario) {

        membroService.save(usuario.getMembro());

        usuario.setHabilitado(Boolean.TRUE);
        usuario.setVersao(1L);
        usuario.setDataCriacao(LocalDate.now());
        usuario.setContadorSeguidores(0);
        usuario.setContadorSeguindo(0);
        usuario.setReputacao(0);
        //usuario.setRole("USUARIO");
        usuario.setVerificado(Boolean.FALSE);

        return repository.save(usuario);
    }
    
    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public Usuario findById(Long id) {
        return repository.findById(id).get();
    }

    public Usuario findByEmail(String email) {
        List<Usuario> usuarios = repository.findAll();
        for(Usuario usuario : usuarios) {
            if(usuario.getEmail().equals(email)) {
                return usuario;
            }
        };
        return null;
    }

    @Transactional
    public void update(Long id, Usuario usuarioAlterado) {

        Usuario usuario = repository.findById(id).get();
        usuario.setNome(usuarioAlterado.getNome());
        usuario.setCpf(usuarioAlterado.getCpf());
        usuario.setEmail(usuarioAlterado.getEmail());
        //usuario.setSenha(usuarioAlterado.getSenha());
        usuario.setBairro(usuarioAlterado.getBairro());
        usuario.setCidade(usuarioAlterado.getCidade());
        usuario.setAvatar(usuarioAlterado.getAvatar());
        //usuario.setRole(usuarioAlterado.getRole());
        usuario.setReputacao(usuarioAlterado.getReputacao());
        usuario.setVerificado(usuarioAlterado.getVerificado());
        usuario.setContadorSeguidores(usuarioAlterado.getContadorSeguidores());
        usuario.setContadorSeguindo(usuarioAlterado.getContadorSeguindo());
        
        usuario.setVersao(usuario.getVersao() + 1);
        usuario.setDataUltimaModificacao(LocalDate.now());
        repository.save(usuario);
    }

    @Transactional
    public void delete(Long id) {
        
        Usuario usuario = repository.findById(id).get();
        usuario.setHabilitado(Boolean.FALSE);
        
        usuario.setVersao(usuario.getVersao() + 1);
        usuario.setDataUltimaModificacao(LocalDate.now());
        repository.save(usuario);
    }

}
