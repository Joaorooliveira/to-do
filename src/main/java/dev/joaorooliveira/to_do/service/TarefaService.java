package dev.joaorooliveira.to_do.service;

import dev.joaorooliveira.to_do.repository.TarefaRepository;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }
}
