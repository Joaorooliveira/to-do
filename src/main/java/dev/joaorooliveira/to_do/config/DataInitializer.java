package dev.joaorooliveira.to_do.config;

import dev.joaorooliveira.to_do.domain.Tarefa;
import dev.joaorooliveira.to_do.enums.TipoPrioridade;
import dev.joaorooliveira.to_do.enums.TipoStatus;
import dev.joaorooliveira.to_do.repository.TarefaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(TarefaRepository tarefaRepository) {
        return args -> {

            Tarefa tarefa1 = new Tarefa();
            tarefa1.setTitulo("Estudar Java");
            tarefa1.setDescricao("Revisar fundamentos da linguagem Java");
            tarefa1.setStatus(TipoStatus.PENDENTE);
            tarefa1.setPrioridade(TipoPrioridade.ALTA);
            tarefa1.setPrazo(LocalDate.of(2026, 9, 1));

            Tarefa tarefa2 = new Tarefa();
            tarefa2.setTitulo("Aprender Spring Boot");
            tarefa2.setDescricao("Estudar Controllers, Services e Repositories");
            tarefa2.setStatus(TipoStatus.EM_ANDAMENTO);
            tarefa2.setPrioridade(TipoPrioridade.ALTA);
            tarefa2.setPrazo(LocalDate.of(2026, 9, 5));

            Tarefa tarefa3 = new Tarefa();
            tarefa3.setTitulo("Estudar SQL");
            tarefa3.setDescricao("Praticar SELECT, WHERE, GROUP BY e HAVING");
            tarefa3.setStatus(TipoStatus.PENDENTE);
            tarefa3.setPrioridade(TipoPrioridade.MEDIA);
            tarefa3.setPrazo(LocalDate.of(2026, 9, 10));

            Tarefa tarefa4 = new Tarefa();
            tarefa4.setTitulo("Revisar POO");
            tarefa4.setDescricao("Revisar herança, polimorfismo e encapsulamento");
            tarefa4.setStatus(TipoStatus.CONCLUIDA);
            tarefa4.setPrioridade(TipoPrioridade.BAIXA);
            tarefa4.setPrazo(LocalDate.of(2026, 9, 12));

            Tarefa tarefa5 = new Tarefa();
            tarefa5.setTitulo("Estudar Banco de Dados");
            tarefa5.setDescricao("Revisar conceitos de modelagem e relacionamentos");
            tarefa5.setStatus(TipoStatus.PENDENTE);
            tarefa5.setPrioridade(TipoPrioridade.ALTA);
            tarefa5.setPrazo(LocalDate.of(2026, 9, 15));

            Tarefa tarefa6 = new Tarefa();
            tarefa6.setTitulo("Criar API de tarefas");
            tarefa6.setDescricao("Implementar endpoints CRUD da aplicação");
            tarefa6.setStatus(TipoStatus.EM_ANDAMENTO);
            tarefa6.setPrioridade(TipoPrioridade.ALTA);
            tarefa6.setPrazo(LocalDate.of(2026, 9, 18));

            Tarefa tarefa7 = new Tarefa();
            tarefa7.setTitulo("Estudar Git");
            tarefa7.setDescricao("Revisar branches, merge, rebase e conflitos");
            tarefa7.setStatus(TipoStatus.CONCLUIDA);
            tarefa7.setPrioridade(TipoPrioridade.MEDIA);
            tarefa7.setPrazo(LocalDate.of(2026, 9, 20));

            Tarefa tarefa8 = new Tarefa();
            tarefa8.setTitulo("Aprender Docker");
            tarefa8.setDescricao("Criar Dockerfile e Docker Compose");
            tarefa8.setStatus(TipoStatus.PENDENTE);
            tarefa8.setPrioridade(TipoPrioridade.MEDIA);
            tarefa8.setPrazo(LocalDate.of(2026, 9, 22));

            Tarefa tarefa9 = new Tarefa();
            tarefa9.setTitulo("Estudar Spring Data JPA");
            tarefa9.setDescricao("Praticar consultas e Specifications");
            tarefa9.setStatus(TipoStatus.EM_ANDAMENTO);
            tarefa9.setPrioridade(TipoPrioridade.ALTA);
            tarefa9.setPrazo(LocalDate.of(2026, 9, 25));

            Tarefa tarefa10 = new Tarefa();
            tarefa10.setTitulo("Revisar Segurança");
            tarefa10.setDescricao("Estudar conceitos básicos de segurança de aplicações");
            tarefa10.setStatus(TipoStatus.PENDENTE);
            tarefa10.setPrioridade(TipoPrioridade.BAIXA);
            tarefa10.setPrazo(LocalDate.of(2026, 9, 28));

            Tarefa tarefa11 = new Tarefa();
            tarefa11.setTitulo("Estudar REST API");
            tarefa11.setDescricao("Revisar HTTP, métodos e códigos de status");
            tarefa11.setStatus(TipoStatus.CONCLUIDA);
            tarefa11.setPrioridade(TipoPrioridade.MEDIA);
            tarefa11.setPrazo(LocalDate.of(2026, 10, 1));

            Tarefa tarefa12 = new Tarefa();
            tarefa12.setTitulo("Praticar Java Streams");
            tarefa12.setDescricao("Resolver exercícios usando Stream API");
            tarefa12.setStatus(TipoStatus.PENDENTE);
            tarefa12.setPrioridade(TipoPrioridade.MEDIA);
            tarefa12.setPrazo(LocalDate.of(2026, 10, 5));

            Tarefa tarefa13 = new Tarefa();
            tarefa13.setTitulo("Estudar Testes");
            tarefa13.setDescricao("Aprender testes unitários com JUnit");
            tarefa13.setStatus(TipoStatus.PENDENTE);
            tarefa13.setPrioridade(TipoPrioridade.BAIXA);
            tarefa13.setPrazo(LocalDate.of(2026, 10, 10));

            Tarefa tarefa14 = new Tarefa();
            tarefa14.setTitulo("Revisar Spring Security");
            tarefa14.setDescricao("Estudar autenticação e autorização");
            tarefa14.setStatus(TipoStatus.EM_ANDAMENTO);
            tarefa14.setPrioridade(TipoPrioridade.ALTA);
            tarefa14.setPrazo(LocalDate.of(2026, 10, 15));

            Tarefa tarefa15 = new Tarefa();
            tarefa15.setTitulo("Projeto final Java");
            tarefa15.setDescricao("Finalizar projeto de estudos em Java e Spring");
            tarefa15.setStatus(TipoStatus.PENDENTE);
            tarefa15.setPrioridade(TipoPrioridade.ALTA);
            tarefa15.setPrazo(LocalDate.of(2026, 10, 20));

            tarefaRepository.save(tarefa1);
            tarefaRepository.save(tarefa2);
            tarefaRepository.save(tarefa3);
            tarefaRepository.save(tarefa4);
            tarefaRepository.save(tarefa5);
            tarefaRepository.save(tarefa6);
            tarefaRepository.save(tarefa7);
            tarefaRepository.save(tarefa8);
            tarefaRepository.save(tarefa9);
            tarefaRepository.save(tarefa10);
            tarefaRepository.save(tarefa11);
            tarefaRepository.save(tarefa12);
            tarefaRepository.save(tarefa13);
            tarefaRepository.save(tarefa14);
            tarefaRepository.save(tarefa15);
        };
    }
}