package dev.joaorooliveira.to_do.projection;

import dev.joaorooliveira.to_do.enums.TipoStatus;

public interface PrioridadeAltaProjection {

    String getTitulo();
    String getDescricao();
    TipoStatus getStatus();
}
