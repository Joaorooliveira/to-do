package dev.joaorooliveira.to_do.dto;

import dev.joaorooliveira.to_do.enums.TipoPrioridade;
import dev.joaorooliveira.to_do.enums.TipoStatus;

import java.time.LocalDate;

public record TarefaAtualizarDTO(
        String titulo,
        String descricao,
        TipoStatus status,
        TipoPrioridade prioridade,
        LocalDate prazo
) {
}
