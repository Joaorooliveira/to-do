package dev.joaorooliveira.to_do.service;

import dev.joaorooliveira.to_do.dto.TarefaAtualizarDTO;
import dev.joaorooliveira.to_do.dto.TarefaFiltroRequestDTO;
import dev.joaorooliveira.to_do.dto.TarefaRequestDTO;
import dev.joaorooliveira.to_do.dto.TarefaResponseDTO;
import dev.joaorooliveira.to_do.repository.TarefaRepository;
import dev.joaorooliveira.to_do.specification.TarefaSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<TarefaResponseDTO> buscarTarefa(TarefaFiltroRequestDTO filtro, Pageable pageable) {
        return tarefaRepository.findAll(TarefaSpecification.comFiltros(filtro), pageable)
                .map(TarefaResponseDTO::fromEntity);
    }

    @Transactional
    public void excluirTarefa(Long id) {
        var tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        tarefaRepository.delete(tarefa);
    }

    @Transactional
    public TarefaResponseDTO atualizarTarefa(Long id, TarefaAtualizarDTO dto) {
        var tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        dto.preencher(tarefa);
        tarefaRepository.save(tarefa);
        return TarefaResponseDTO.fromEntity(tarefa);
    }



}
