package br.edu.ifpe.olhovigilanteapi.modelo.comentario;

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
@Table(name = "Comentario")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comentario extends EntidadeAuditavel {

   @Column(nullable = false)
   private String texto;

   @Column
   private Integer avaliacao;

   @Column
   private Long ocorrenciaId;
   
   //@Column(nullable = false)
   //private Long usuarioId; // equivalente a "criadoPor" em EntidadeAuditavel?

}
