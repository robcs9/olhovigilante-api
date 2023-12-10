package br.edu.ifpe.olhovigilanteapi.modelo.ocorrencia;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
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
@Table(name = "Ocorrencia")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ocorrencia extends EntidadeAuditavel {
   
   @ManyToOne
   private CategoriaOcorrencia categoria;

   @ManyToOne
   private Usuario usuario;

   @Column(nullable = false)
   private String descricao;
   
   @Column(nullable = false)
   private Integer avaliacao;
   
   @Column(nullable = false)
   private String cidade;

   @Column(nullable = false)
   private String bairro;

   @Column
   private String geolocalizacao;
   
   @Column(nullable = false)
   private LocalDate dataHoraOcorrencia; // separar em private LocalDate data; private LocalTime hora; ?
   
   // Atributos abaixo serão removidos ou não futuramente (pendente)
   @Column
   private Boolean presencaPolicial;
   
   @Column
   private Boolean acaoPolicial;
   
   @Column
   private String motivacao;
   
   @Column
   private Integer qtdVitimas;

}
