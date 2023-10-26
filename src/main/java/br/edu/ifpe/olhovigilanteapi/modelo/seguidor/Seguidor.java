package br.edu.ifpe.olhovigilanteapi.modelo.seguidor;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import br.edu.ifpe.olhovigilanteapi.modelo.usuario.Usuario;
import br.edu.ifpe.olhovigilanteapi.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Seguidor")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Seguidor extends EntidadeAuditavel {

   //@OneToMany
   //private List<Usuario> usuariosSeguidores;
//
   //private List<Usuario> usuariosSeguidos;

   @Column (nullable = false)
   private Long usuarioSeguidorId;

   @Column (nullable = false)
   private Long usuarioSeguidoId;
}
