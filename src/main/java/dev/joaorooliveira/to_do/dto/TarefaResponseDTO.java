package dev.joaorooliveira.to_do.dto;

import dev.joaorooliveira.to_do.domain.Tarefa;
import dev.joaorooliveira.to_do.enums.TipoPrioridade;
import dev.joaorooliveira.to_do.enums.TipoStatus;

import java.time.LocalDate;

public record TarefaResponseDTO(
        Long id,
        String titulo,
        String descricao,
        TipoStatus status,
        TipoPrioridade prioridade,
        LocalDate prazo
) {
    public static TarefaResponseDTO fromEntity(Tarefa tarefa) {
        return new TarefaResponseDTO(
                tarefa.getId(),
                tarefa.getTitulo(),
                tarefa.getDescricao(),
                tarefa.getStatus(),
                tarefa.getPrioridade(),
                tarefa.getPrazo()
        );
    }
}
