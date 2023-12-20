package br.edu.ifpe.olhovigilanteapi.api.ocorrencia;

import java.time.LocalDate;
import java.time.LocalTime;

import br.edu.ifpe.olhovigilanteapi.modelo.ocorrencia.Ocorrencia;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OcorrenciaRequest {

    private Long usuarioId;

    private Long categoriaId;

    private String descricao;

    private Integer avaliacao;

    private String cidade;
    
    private String bairro;
    
    private String geolocalizacao;
    
    private LocalDate dataHoraOcorrencia;

    private LocalTime hora;
    
    // private Boolean presencaPolicial;
    
    // private Boolean acaoPolicial;
    
    // private String tipoOcorrencia;
    
    // private String motivacao;
    
    // private Integer qtdVitimas;
    

    public Ocorrencia build() {

        return Ocorrencia.builder()
            .descricao(descricao)
            .avaliacao(avaliacao)
            .cidade(cidade)
            .bairro(bairro)
            .geolocalizacao(geolocalizacao)
            .dataHoraOcorrencia(dataHoraOcorrencia)
            .hora(hora)
            // .presencaPolicial(presencaPolicial)
            // .acaoPolicial(acaoPolicial)
            // .motivacao(motivacao)
            // .qtdVitimas(qtdVitimas)
            .build();
    }
}
