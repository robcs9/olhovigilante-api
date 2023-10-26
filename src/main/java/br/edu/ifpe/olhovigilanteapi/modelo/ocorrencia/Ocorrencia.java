package br.edu.ifpe.olhovigilanteapi.modelo.ocorrencia;

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

enum TipoOcorrencia {
   ASSALTO,
   LATROCÍNIO,
   ROUBO,
   FURTO,
   TRÁFICO,
   HOMICÍDIO,
   FEMINICÍDIO
}

@Entity
@Table(name = "Ocorrencia")
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ocorrencia extends EntidadeAuditavel {

   @Column(nullable = false)
   private String descricao;
   
   @Column
   private Integer avaliacao;
   
   @Column(nullable = false)
   private String cidade;

   @Column(nullable = false)
   private String bairro;

   @Column(nullable = false)
   private String geolocalizacao;
   
   @Column(nullable = false)
   private LocalDate dataHoraOcorrencia;
   
   @Column
   private Boolean presencaPolicial;
   
   @Column
   private Boolean acaoPolicial;

   @Column(nullable = false)
   private String tipoOcorrencia;
   
   @Column
   private String motivacao;
   
   @Column
   private Integer qtdVitimas;

}
