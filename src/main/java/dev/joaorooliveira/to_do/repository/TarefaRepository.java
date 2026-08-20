package dev.joaorooliveira.to_do.repository;

import dev.joaorooliveira.to_do.domain.Tarefa;
import dev.joaorooliveira.to_do.projection.PrioridadeAltaProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>, JpaSpecificationExecutor<Tarefa> {

    @Query(
            value = """
            SELECT
                titulo,
                descricao,
                status
            FROM tarefa
            WHERE prioridade = 'ALTA'
            """,
            nativeQuery = true
    )
    List<PrioridadeAltaProjection> prioridadeAlta();

}
