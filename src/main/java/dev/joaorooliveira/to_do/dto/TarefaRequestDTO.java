package dev.joaorooliveira.to_do.dto;

import dev.joaorooliveira.to_do.domain.Tarefa;
import dev.joaorooliveira.to_do.enums.TipoPrioridade;
import dev.joaorooliveira.to_do.enums.TipoStatus;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record TarefaRequestDTO(

        @NotBlank(message = "O título da tarefa é obrigatório")
        String titulo,
        @NotBlank(message = "A descricao da tarefa é obrigatório")
        String descricao,

        @NotNull(message = "O status da tarefa é obrigatório")
        TipoStatus status,

        @NotNull(message = "A prioridade da tarefa é obrigatória")
        TipoPrioridade prioridade,

        @Future(message = "O prazo da tarefa deve ser uma data futura")
        LocalDate prazo
) {

    public Tarefa toEntity() {
        Tarefa tarefa = new Tarefa();
        preencher(tarefa);
        return tarefa;
    }

    public void preencher(Tarefa tarefa) {
        tarefa.setTitulo(this.titulo);
        tarefa.setDescricao(this.descricao);
        tarefa.setStatus(this.status);
        tarefa.setPrioridade(this.prioridade);
        tarefa.setPrazo(this.prazo);
    }
}
