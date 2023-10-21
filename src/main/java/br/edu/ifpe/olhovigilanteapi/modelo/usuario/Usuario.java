package br.edu.ifpe.olhovigilanteapi.modelo.usuario;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import br.edu.ifpe.olhovigilanteapi.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Usuario")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario extends EntidadeAuditavel {

   @Column
   private String nome;

   @Column
   private String cpf;

   @Column
   private String email;

   @Column
   private String senha;

   @Column
   private String bairro;

   @Column
   private String cidade;

   @Column
   private String avatar;

   @Column
   private String role;

   @Column
   private Integer reputacao;

   @Column
   private Boolean verificado;

   @Column
   private Integer contadorSeguidores;

   @Column
   private Integer contadorSeguindo;

}
