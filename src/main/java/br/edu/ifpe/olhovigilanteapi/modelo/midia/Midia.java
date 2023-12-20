package br.edu.ifpe.olhovigilanteapi.modelo.midia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import br.edu.ifpe.olhovigilanteapi.modelo.ocorrencia.Ocorrencia;
import br.edu.ifpe.olhovigilanteapi.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Midia")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Midia extends EntidadeAuditavel {

   /* @ManyToOne
   @JoinColumn(nullable = false)
   private Ocorrencia ocorrencia; */

   @Column(nullable = false)
   private String midiaUrl;

   /*@JoinColumn(nullable = false) */
   /* @ManyToOne
   private Ocorrencia ocorrencia; */
   
   @Column
   private Long ocorrenciaId;

   @Column
   private Long comentarioId;

}
