package dev.joaorooliveira.to_do.dto;

import dev.joaorooliveira.to_do.domain.Tarefa;
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

    public Tarefa toEntity(TarefaAtualizarDTO dto) {
        Tarefa tarefa = new Tarefa();
        preencher(tarefa);
        return tarefa;
    }

    public void preencher(Tarefa tarefa) {
        if (titulo != null) {
            tarefa.setTitulo(titulo);
        }
        if (descricao != null) {
            tarefa.setDescricao(descricao);
        }
        if (status != null) {
            tarefa.setStatus(status);
        }
        if (prioridade != null) {
            tarefa.setPrioridade(prioridade);
        }
        if (prazo != null) {
            tarefa.setPrazo(prazo);
        }
    }
}
