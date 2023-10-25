package br.edu.ifpe.olhovigilanteapi.modelo.seguidor;

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
public class Seguidor extends EntidadeAuditavel {

   @Column(nullable = false)
   private Long usuarioSeguidorId;

   @Column(nullable = false)
   private Long usuarioSeguidoId;
}
