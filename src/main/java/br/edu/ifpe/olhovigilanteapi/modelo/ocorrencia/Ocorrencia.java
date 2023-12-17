package br.edu.ifpe.olhovigilanteapi.modelo.ocorrencia;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.repository.Query;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.edu.ifpe.olhovigilanteapi.modelo.midia.Midia;
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

   @OneToMany(mappedBy = "ocorrenciaId", orphanRemoval = true, fetch = FetchType.EAGER)
   @Fetch(FetchMode.SUBSELECT)
   private List<Midia> midias;
   
   /* @OneToMany(mappedBy = "ocorrencia")
   private List<Midia> midias; */
   
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
   @JsonFormat(pattern = "dd/MM/yyyy", locale = "pt_BR")
   private LocalDate dataHoraOcorrencia;

   @Column
   @JsonFormat(pattern = "HH:mm")
   private LocalTime hora;

   // No need for a media attribute because of reletationship (join with "midia")
   // and retrieve all the media urls from the db whenever a select request is made
   // on the 'ocorrência' entity.

   /*
    * @Column(nullable = false)
    * private LocalDate data;
    * 
    * @Column
    * private LocalTime hora;
    */

   // Atributos abaixo passíveis de remoção
   @Column
   private Boolean presencaPolicial;

   @Column
   private Boolean acaoPolicial;

   @Column
   private String motivacao;

   @Column
   private Integer qtdVitimas;

}
