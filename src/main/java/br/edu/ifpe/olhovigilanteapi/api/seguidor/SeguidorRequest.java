package br.edu.ifpe.olhovigilanteapi.api.seguidor;

import br.edu.ifpe.olhovigilanteapi.modelo.seguidor.Seguidor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeguidorRequest {

    private Long usuarioSeguidorId;

    private Long usuarioSeguidoId;

    public Seguidor build() {

        return Seguidor.builder()
            .usuarioSeguidoId(usuarioSeguidoId)
            .usuarioSeguidorId(usuarioSeguidorId)
            .build();
    }
}
