# API Validadora de Senhas

![Java](https://img.shields.io/badge/Java-blue.svg) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.4-brightgreen.svg) ![Maven](https://img.shields.io/badge/Maven-3.x-red.svg)

## 1. Visão Geral do Projeto

Esta é uma API RESTful desenvolvida em **Java 17** com **Spring Boot**, projetada para validar a força de senhas com base em um conjunto de regras de negócio customizáveis. A solução foi construída com foco em **Clean Code**, **SOLID**, extensibilidade e alta cobertura de testes, demonstrando práticas de desenvolvimento de software modernas e robustas.

O principal objetivo é expor um endpoint que recebe uma senha e retorna uma resposta clara, indicando se ela é válida e, em caso de falha, quais critérios não foram atendidos.

## 2. Decisões de Arquitetura e Design

Nesta seção, detalho as decisões técnicas que moldaram a estrutura do projeto, focando em justificar o *porquê* de cada escolha.

### 2.1. Padrão Strategy e Princípio Aberto/Fechado (OCP)

-   **Decisão**: A lógica de validação foi decomposta em múltiplas classes que implementam uma interface comum (`Regra`). Uma classe central (`ValidadorPadraoSenha`) recebe uma lista dessas regras e as executa em sequência.

-   **Justificativa**: Esta abordagem implementa o **Padrão de Projeto Strategy**. Ela adere ao **Princípio Aberto/Fechado (OCP)**, pois o sistema está *aberto para extensão* (novas regras podem ser adicionadas facilmente criando novas classes) e *fechado para modificação* (o validador principal não precisa ser alterado para acomodar novas regras). Isso torna o sistema flexível e de fácil manutenção.

### 2.2. Injeção de Dependência e Inversão de Controle (IoC)

-   **Decisão**: As dependências (como `ServicoValidacaoSenha` e `ValidadorSenha`) são injetadas através de construtores, e a configuração das regras é centralizada em uma classe `@Configuration`.

-   **Justificativa**: Utilizamos o contêiner de **Inversão de Controle (IoC)** do Spring para gerenciar o ciclo de vida dos objetos. A injeção via construtor garante que as dependências sejam explícitas e que os objetos sejam criados em um estado válido e imutável. Programar para interfaces (`ValidadorSenha`) em vez de implementações concretas desacopla os componentes, facilitando a substituição e os testes (Princípio da Inversão de Dependência - DIP).

### 2.3. DTOs (Data Transfer Objects) e Imutabilidade

-   **Decisão**: Foram criados DTOs específicos para a requisição (`RequisicaoSenha`) e a resposta (`RespostaSenha`). O objeto de resultado interno (`ResultadoValidacao`) foi projetado para ser imutável.

-   **Justificativa**: O uso de DTOs desacopla a representação externa da API do modelo de domínio interno. Isso permite que a API evolua sem quebrar a lógica de negócio. A imutabilidade em `ResultadoValidacao` torna o código mais seguro e previsível, evitando efeitos colaterais indesejados.

### 2.4. Uso de `Optional` para Retorno de Regras

-   **Decisão**: A interface `Regra` define que o método `validar` retorna um `Optional<String>`.

-   **Justificativa**: Esta escolha de design torna a API interna mais expressiva e segura. Em vez de retornar `null` ou uma string vazia para indicar sucesso, o `Optional.empty()` comunica claramente a ausência de um erro. Isso força o código cliente (o validador) a lidar explicitamente com a possibilidade de uma falha, prevenindo `NullPointerException`.

## 3. Como Executar a Aplicação

Siga os passos abaixo para compilar, testar e executar o projeto localmente.

### Pré-requisitos

-   **Java 17** ou superior
-   **Apache Maven** 3.6 ou superior

### Passos

1.  **Clone o repositório:**
    ```bash
    git clone Case_PasswordValidator
    cd Case_PasswordValidator
    ```

2.  **Compile e execute os testes:**
    O comando `package` compila o código, executa todos os testes unitários e de integração, e empacota a aplicação em um arquivo `.jar`.
    ```bash
    mvn clean package
    ```

3.  **Execute a aplicação:**
    Você pode iniciar o servidor de duas maneiras:

    *   **Usando o plugin do Spring Boot (recomendado para desenvolvimento):**
        ```bash
        mvn spring-boot:run
        ```
    *   **Executando o arquivo JAR (ideal para produção):**
        ```bash
        java -jar target/password-validator-0.0.1-SNAPSHOT.jar
        ```

A API estará disponível em `http://localhost:8080`.

## 4. Endpoint da API

A API expõe um único endpoint para a validação de senhas.

-   **Endpoint**: `POST /api/v1/senha/validar`
-   **Content-Type**: `application/json`

### Exemplo de Requisição

**Corpo da Requisição (Body):**
```json
{
  "senha": "AbTp9!fok"
}
```

### Exemplo de Resposta (Sucesso)

**Status**: `200 OK`
**Corpo da Resposta:**
```json
{
  "valido": true,
  "erros": []
}
```

### Exemplo de Resposta (Falha)

**Requisição:**
```json
{
  "senha": "senha fraca"
}
```

**Resposta:**
```json
{
  "valido": false,
  "erros": [
    "senha deve ter ao menos 9 caracteres",
    "senha deve conter ao menos um dígito",
    "senha deve conter ao menos uma letra maiúscula",
    "senha deve conter ao menos um caractere especial: !@#$%^&*()-+",
    "caractere repetido: 'a'"
  ]
}
```

## 5. Cobertura de Testes

O projeto possui uma suíte de testes robusta que valida tanto a lógica de negócio quanto a integração da API.

-   **Testes Unitários (`ServicoValidacaoSenhaTest`, `ValidadorPadraoSenhaTest`, etc.):** Focam em testar cada regra de validação isoladamente, garantindo que a lógica de negócio esteja correta.
-   **Testes de Integração (`ControladorSenhaTest`):** Utilizam `@WebMvcTest` para testar a camada de controle, simulando requisições HTTP e verificando se as respostas estão corretas, sem a necessidade de subir um servidor completo.

Para executar os testes, utilize o comando:
```bash
mvn test
```



