package br.edu.ifpe.olhovigilanteapi.api.acesso;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpe.olhovigilanteapi.modelo.acesso.Membro;
import br.edu.ifpe.olhovigilanteapi.modelo.acesso.MembroService;
import br.edu.ifpe.olhovigilanteapi.seguranca.jwt.JwtTokenProvider;

@RestController
@RequestMapping("/api/login")
@CrossOrigin
public class AuthenticationController {

    @Autowired
    private MembroService membroService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping
    public Map<Object, Object> signin(@RequestBody AuthenticationRequest data) {

        try {

            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(data.getUsername(), data.getPassword()));

            Membro membro = this.membroService.findByUsername(data.getUsername());
            String token = jwtTokenProvider.createToken(membro.getUsername(), membro.getRoles());
            String refreshToken = jwtTokenProvider.createRefreshToken(membro.getUsername());

            Map<Object, Object> model = new HashMap<>();
            model.put("username", membro.getUsername());
            model.put("token", token);
            model.put("refresh", refreshToken);

            return model;

        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }

}