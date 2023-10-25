package br.edu.ifpe.olhovigilanteapi.modelo.comentario;

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

enum Avaliacao {
   POSITIVA,
   NEGATIVA
}

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

   @Column(nullable = false)
   private Avaliacao avaliacao;

   @Column
   private Long ocorrenciaId;
   
   //@Column(nullable = false)
   //private Long usuarioId; // equivalente a "criadoPor" em EntidadeAuditavel?

}
