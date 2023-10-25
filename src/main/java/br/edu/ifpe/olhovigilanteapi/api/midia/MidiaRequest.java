package br.edu.ifpe.olhovigilanteapi.api.midia;

import br.edu.ifpe.olhovigilanteapi.modelo.midia.Midia;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MidiaRequest {
   
   private String midiaUrl;

   private Long ocorrenciaId;

   private Long comentarioId;

    public Midia build() {

        return Midia.builder()
            .midiaUrl(midiaUrl)
            .ocorrenciaId(ocorrenciaId)
            .comentarioId(comentarioId)
            .build();
    }
}
