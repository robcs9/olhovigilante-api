package br.edu.ifpe.olhovigilanteapi.api.seguindo_seguidor;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.edu.ifpe.olhovigilanteapi.modelo.usuario.Midia;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequest {

   private String nome;    
   
   private String cpf;    
   
   private String email;    
   
   private String senha;    
   
   private String bairro;    
   
   private String cidade;    
   
   private String avatar;    
   
   private String role;    
   
   private Integer reputacao;   
   
   private Boolean verificado;  
   
   private Integer contadorSeguidores;   
   
   private Integer contadorSeguindo;

    public Midia build() {

        return Midia.builder()
            .nome(nome)
            .cpf(cpf)
            .email(email)
            .senha(senha)
            .bairro(bairro)
            .cidade(cidade)
            .avatar(avatar)
            .role(role)
            .reputacao(reputacao)
            .verificado(verificado)
            .contadorSeguidores(contadorSeguidores)
            .contadorSeguindo(contadorSeguindo)
            .build();
    }
}
