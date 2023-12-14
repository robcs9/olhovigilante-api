package br.edu.ifpe.olhovigilanteapi.modelo.usuario;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.edu.ifpe.olhovigilanteapi.modelo.ocorrencia.Ocorrencia;
import br.edu.ifpe.olhovigilanteapi.modelo.acesso.Membro;
import br.edu.ifpe.olhovigilanteapi.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/* enum Role {
   //VISITANTE,
   USUARIO,
   ADMINISTRADOR
} */

@Entity
@Table(name = "Usuario")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario extends EntidadeAuditavel {

   @OneToOne
   @JoinColumn(nullable=false)
   private Membro membro;

   @Column (nullable = false)
   private String nome;

   @Column(nullable = false, unique = true)
   private String cpf;

   @Column (nullable = false, unique = true)
   private String email;

   //@Column (nullable = false)
   //private String senha;

   @Column
   private String bairro;

   @Column
   private String cidade;

   @Column
   private String avatar;
   
   //@Column //(nullable = false)
   //private String role;

   @Column //(nullable = false)
   private Integer reputacao;
   
   @Column //(nullable = false)
   private Boolean verificado;

   @Column //(nullable = false)
   private Integer contadorSeguidores;

   @Column //(nullable = false)
   private Integer contadorSeguindo;

   //@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
   //private List<Ocorrencia> ocorrencias; 

}
