package br.edu.ifpe.olhovigilanteapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.edu.ifpe.olhovigilanteapi.modelo.acesso.Membro;
import br.edu.ifpe.olhovigilanteapi.modelo.acesso.MembroService;
import br.edu.ifpe.olhovigilanteapi.seguranca.jwt.JwtAuthenticationEntryPoint;
import br.edu.ifpe.olhovigilanteapi.seguranca.jwt.JwtTokenAuthenticationFilter;
import br.edu.ifpe.olhovigilanteapi.seguranca.jwt.JwtTokenProvider;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {

    private static final String[] AUTH_WHITELIST = {
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/swagger*/**",
            "/v2/api-docs",
            "/webjars/**",
            "/routes/**",
            "/favicon.ico",
            "/ws/**",
            "/**" // Liberar todas as rotas (somente para TESTES)
            // "/delifacil/**/dadosPedidoNew/**",
            // "/delifacil/image/**"
    };

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private JwtAuthenticationEntryPoint authenticationEntryPoint;

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder,
            MembroService userDetailService) throws Exception {

        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailService)
                .passwordEncoder(bCryptPasswordEncoder)
                .and()
                .build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .httpBasic().disable().csrf().disable().cors().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint).and().authorizeRequests()

                .antMatchers(AUTH_WHITELIST).permitAll()
                
                .antMatchers(HttpMethod.POST, "/api/login").permitAll() // Todos podem fazer login

                .antMatchers(HttpMethod.POST, "/api/usuario").permitAll() // Todos podem se cadastrar como usuario
                .antMatchers(HttpMethod.GET, "/api/usuario/")
                .hasAnyAuthority(Membro.ROLE_USUARIO, Membro.ROLE_ADMINISTRADOR) // /usuario/ é diferente de apenas /usuario
                .antMatchers(HttpMethod.PUT, "/api/usuario/*").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/usuario/*").permitAll()

                .antMatchers(HttpMethod.POST, "/api/ocorrencia").permitAll()
                .antMatchers(HttpMethod.GET, "/api/ocorrencia").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/ocorrencia").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/ocorrencia").permitAll()

                .antMatchers(HttpMethod.POST, "/api/categoriaocorrencia").permitAll()
                .antMatchers(HttpMethod.GET, "/api/categoriaocorrencia").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/categoriaocorrencia").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/categoriaocorrencia").permitAll()

                .antMatchers(HttpMethod.POST, "/api/midia").permitAll()
                .antMatchers(HttpMethod.GET, "/api/midia").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/midia").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/midia").permitAll()

                .antMatchers(HttpMethod.POST, "/api/comentario").permitAll()
                .antMatchers(HttpMethod.GET, "/api/comentario").permitAll()
                .antMatchers(HttpMethod.PUT, "/api/comentario").permitAll()
                .antMatchers(HttpMethod.DELETE, "/api/comentario").permitAll()

                .anyRequest()
                .hasAnyAuthority(Membro.ROLE_USUARIO, Membro.ROLE_ADMINISTRADOR)
                .and().addFilterBefore(
                        new JwtTokenAuthenticationFilter(jwtTokenProvider),
                        UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {

        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }

}