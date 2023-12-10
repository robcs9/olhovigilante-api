package br.edu.ifpe.olhovigilanteapi.modelo.acesso;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MembroService implements UserDetailsService {
    @Autowired
    private MembroRepository repository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public Membro save(Membro user) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setHabilitado(Boolean.TRUE);
        return repository.save(user);
    }

    @Transactional
    public Membro findByUsername(String username) {

        return repository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        return repository.findByUsername(username);
    }

}
