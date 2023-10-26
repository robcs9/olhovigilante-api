package br.edu.ifpe.olhovigilanteapi.api.comentario;

import br.edu.ifpe.olhovigilanteapi.modelo.comentario.Comentario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComentarioRequest {

    private String texto;

    private Integer avaliacao;

    private Long ocorrenciaId;

    public Comentario build() {

        return Comentario.builder()
                .texto(texto)
                .avaliacao(avaliacao)
                .ocorrenciaId(ocorrenciaId)
                .build();
    }
}
