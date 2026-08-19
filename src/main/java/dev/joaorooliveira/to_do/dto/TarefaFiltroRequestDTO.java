package dev.joaorooliveira.to_do.dto;

import dev.joaorooliveira.to_do.enums.TipoPrioridade;
import dev.joaorooliveira.to_do.enums.TipoStatus;
import jakarta.validation.constraints.AssertTrue;

import java.time.LocalDate;

public record TarefaFiltroRequestDTO(
        String titulo,
        String descricao,
        TipoStatus status,
        TipoPrioridade prioridade,
        LocalDate prazo,
        LocalDate prazoMinimo,
        LocalDate prazoMaximo
) {
    @AssertTrue(message = "Não é permitido informar prazo junto com prazoMinimo ou prazoMaximo")
    public boolean isFiltroPrazoValido() {
        return prazo == null || (prazoMinimo == null && prazoMaximo == null);
    }

    @AssertTrue(message = "prazoMinimo não pode ser maior que prazoMaximo")
    public boolean isIntervaloPrazoValido() {
        if (prazoMinimo == null || prazoMaximo == null) {
            return true;
        }

        return !prazoMinimo.isAfter(prazoMaximo);
    }
}
