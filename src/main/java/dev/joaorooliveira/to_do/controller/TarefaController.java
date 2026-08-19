package dev.joaorooliveira.to_do.controller;

import dev.joaorooliveira.to_do.dto.TarefaFiltroRequestDTO;
import dev.joaorooliveira.to_do.dto.TarefaRequestDTO;
import dev.joaorooliveira.to_do.dto.TarefaResponseDTO;
import dev.joaorooliveira.to_do.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public ResponseEntity<TarefaResponseDTO> salvar(@RequestBody @Valid TarefaRequestDTO tarefaRequestDTO) {
        TarefaResponseDTO tarefaResponseDTO = tarefaService.salvarTarefa(tarefaRequestDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(tarefaResponseDTO.id())
                .toUri();

        return ResponseEntity.created(location).body(tarefaResponseDTO);
    }

    @GetMapping
    public ResponseEntity<Page<TarefaResponseDTO>> buscar(
            TarefaFiltroRequestDTO filtro, Pageable pageable) {
        return ResponseEntity.ok(tarefaService.buscarTarefa(filtro, pageable));
    }

}
