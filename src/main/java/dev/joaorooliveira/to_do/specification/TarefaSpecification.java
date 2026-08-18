package dev.joaorooliveira.to_do.specification;

import dev.joaorooliveira.to_do.domain.Tarefa;
import dev.joaorooliveira.to_do.dto.TarefaFiltroRequestDTO;
import dev.joaorooliveira.to_do.enums.TipoPrioridade;
import dev.joaorooliveira.to_do.enums.TipoStatus;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class TarefaSpecification {
    public static Specification<Tarefa> comFiltros(TarefaFiltroRequestDTO filtro) {
        return Specification
                .where(nomeContem(filtro.titulo()))
                .and(descricaoContem(filtro.descricao()))
                .and(tipoStatusIgual(filtro.tipoStatus()))
                .and(tipoPrioridadeIgual(filtro.tipoPrioridade()))
                .and(prazoIgual(filtro.prazo()))
                .and(prazoMaiorQueOuIgual(filtro.prazoMinimo()))
                .and(prazoMenorQueOuIgual(filtro.prazoMaximo()));
    }

    public static Specification<Tarefa> nomeContem(String titulo) {
        return (root, query, cb) -> {
            if (titulo == null || titulo.isBlank()) {
                return null;
            }
            return cb.like(cb.lower(root.get("titulo")), "%" + titulo.toLowerCase() + "%");
        };
    }

    public static Specification<Tarefa> descricaoContem(String descricao) {
        return (root, query, cb) -> {
            if (descricao == null || descricao.isBlank()) {
                return null;
            }
            return cb.like(cb.lower(root.get("descricao")), "%" + descricao.toLowerCase() + "%");
        };
    }

    public static Specification<Tarefa> tipoStatusIgual(TipoStatus status) {
        return (root, query, cb) -> {
            if (status == null) {
                return null;
            }
            return cb.equal(root.get("tipoStatus"), status);
        };
    }

    private static Specification<Tarefa> tipoPrioridadeIgual(TipoPrioridade prioridade) {
        return (root, query, cb) -> {
            if (prioridade == null) {
                return null;
            }
            return cb.equal(root.get("tipoPrioridade"), prioridade);
        };
    }

    private static Specification<Tarefa> prazoIgual(LocalDate prazo) {
        return (root, query, cb) -> {
            if (prazo == null) {
                return null;
            }
            return cb.equal(root.get("prazo"), prazo);
        };
    }

    private static Specification<Tarefa> prazoMaiorQueOuIgual(LocalDate prazo) {
        return (root, query, cb) -> {
            if (prazo == null) {
                return null;
            }
            return cb.greaterThanOrEqualTo(root.get("prazo"), prazo);
        };
    }

    private static Specification<Tarefa> prazoMenorQueOuIgual(LocalDate prazo) {
        return (root, query, cb) -> {
            if (prazo == null) {
                return null;
            }
            return cb.lessThanOrEqualTo(root.get("prazo"), prazo);
        };
    }

    private static Specification<Tarefa> prazoEntre(LocalDate prazo, LocalDate prazo1) {
        return (root, query, cb) -> {
            if (prazo == null || prazo1 == null) {
                return null;
            }
            return cb.between(root.get("prazo"), prazo, prazo1);
        };
    }

    private static Specification<Tarefa> prazoMenorQue(LocalDate prazo) {
        return (root, query, cb) -> {
            if (prazo == null) {
                return null;
            }
            return cb.lessThan(root.get("prazo"), prazo);
        };
    }

    private static Specification<Tarefa> prazoMaiorQue(LocalDate prazo) {
        return (root, query, cb) -> {
            if (prazo == null) {
                return null;
            }
            return cb.greaterThan(root.get("prazo"), prazo);
        };
    }
}
