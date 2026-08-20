# 📝 To-Do List API

Uma API REST completa para gerenciamento de tarefas (To-Do List) desenvolvida em **Java** e **Spring Boot**. Este projeto implementa boas práticas de arquitetura de software, separação de responsabilidades (Controller, Service, Repository) e técnicas avançadas de consulta ao banco de dados.

## 🚀 Tecnologias e Ferramentas

* **Java** (Linguagem principal)
* **Spring Boot** (Framework base)
* **Spring Data JPA** (Persistência de dados)
* **JPA Specifications** (Para filtros dinâmicos e complexos)
* **Spring Projections** (Para otimização de consultas específicas)
* **Maven** (Gerenciamento de dependências)

## ✨ Funcionalidades

* **Gerenciamento Completo (CRUD):** Criação, listagem, atualização e remoção de tarefas.
* **Filtros Dinâmicos:** Busca avançada de tarefas combinando diferentes critérios (ex: status, prioridade) utilizando o padrão `Specification` (`TarefaSpecification`).
* **Consultas Otimizadas:** Endpoint específico para listagem de tarefas com prioridade alta, retornando apenas os dados estritamente necessários através de `Projections` (`PrioridadeAltaProjection`).
* **Regras de Negócio Isoladas:** Utilização da camada `Service` para processamento de regras, mantendo os `Controllers` limpos e responsáveis apenas por requisições HTTP.
* **Padronização de Dados:** Uso de DTOs (Data Transfer Objects) para entrada (`RequestDTO`, `AtualizarDTO`, `FiltroRequestDTO`) e saída (`ResponseDTO`) de dados.
* **Carga Inicial:** População automática do banco de dados para testes através da classe `DataInitializer`.

## 📂 Estrutura do Projeto

A arquitetura do projeto segue o padrão de camadas (Layered Architecture):

```
dev.joaorooliveira.to_do/
├── config/         # Configurações gerais (ex: DataInitializer)
├── controller/     # Endpoints REST (TarefaController)
├── domain/         # Entidades mapeadas para o banco de dados (Tarefa)
├── dto/            # Objetos de transferência de dados (Request, Response, Filtro)
├── enums/          # Enumeradores de domínio (TipoPrioridade, TipoStatus)
├── projection/     # Interfaces para consultas otimizadas no banco
├── repository/     # Interfaces do Spring Data JPA (TarefaRepository)
├── service/        # Regras de negócio e lógica da aplicação (TarefaService)
└── specification/  # Construtores de queries dinâmicas (TarefaSpecification)
```

## ⚙️ Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/joaorooliveira/to-do.git
   ```
2. Acesse a pasta do projeto:
   ```bash
   cd to-do
   ```
3. Execute a aplicação usando o Maven Wrapper:
   ```bash
   # No Linux/Mac:
   ./mvnw spring-boot:run

   # No Windows:
   mvnw.cmd spring-boot:run
   ```
4. A API estará disponível, por padrão, em `http://localhost:8080`.

## 🤝 Contribuição

Sinta-se à vontade para fazer um **fork** do projeto e enviar **pull requests**. Toda contribuição é bem-vinda!
