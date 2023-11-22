package br.edu.ifpe.olhovigilanteapi.api.ocorrencia;

import br.edu.ifpe.olhovigilanteapi.modelo.ocorrencia.CategoriaOcorrencia;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaOcorrenciaRequest {

    private String nome;
   
    public CategoriaOcorrencia build() {

        return CategoriaOcorrencia.builder()
            .nome(nome)
            .build();
    }
}
