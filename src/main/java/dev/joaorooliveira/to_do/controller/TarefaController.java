package dev.joaorooliveira.to_do.controller;

import dev.joaorooliveira.to_do.dto.TarefaAtualizarDTO;
import dev.joaorooliveira.to_do.dto.TarefaFiltroRequestDTO;
import dev.joaorooliveira.to_do.dto.TarefaRequestDTO;
import dev.joaorooliveira.to_do.dto.TarefaResponseDTO;
import dev.joaorooliveira.to_do.projection.PrioridadeAltaProjection;
import dev.joaorooliveira.to_do.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<TarefaResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(tarefaService.buscarTarefaPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        tarefaService.excluirTarefa(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaResponseDTO> atualizar(@PathVariable Long id,
                                                       @RequestBody @Valid TarefaAtualizarDTO tarefaAtualizarDTO) {
        TarefaResponseDTO tarefaResponseDTO = tarefaService.atualizarTarefa(id, tarefaAtualizarDTO);
        return ResponseEntity.ok(tarefaResponseDTO);
    }

    @GetMapping("/prioridade-alta")
    public List<PrioridadeAltaProjection> buscarPrioridadeAlta() {
        return tarefaService.listarPrioridadeAlta();
    }
}
