package dev.joaorooliveira.to_do.service;

import dev.joaorooliveira.to_do.dto.TarefaRequestDTO;
import dev.joaorooliveira.to_do.dto.TarefaResponseDTO;
import dev.joaorooliveira.to_do.repository.TarefaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    @Transactional
    public TarefaResponseDTO salvarTarefa(TarefaRequestDTO dto) {
        var tarefa = dto.toEntity();
        tarefaRepository.save(tarefa);
        return TarefaResponseDTO.fromEntity(tarefa);
    }

    public TarefaResponseDTO buscarTarefaPorId(Long id) {
        var tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        return TarefaResponseDTO.fromEntity(tarefa);
    }




}
