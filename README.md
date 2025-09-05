# Validador de Senhas (PT-BR)

Projeto em Java 17 + Spring Boot com classes e mensagens em português. Estrutura pensada para Clean Code e fácil extensibilidade.

## Como executar

Pré-requisitos: Java 17+, Maven

1. Build e testes:
```
mvn clean package
```
2. Rodar local:
```
mvn spring-boot:run
```
ou
```
java -jar target/password-validator-ptbr-0.0.1-SNAPSHOT.jar
```
3. Endpoint:
- POST /api/v1/senha/validar
  - Body: `{ "senha": "AbTp9!fok" }`
  - Response: `{ "valido": true, "erros": [] }`

## Observações
- Repetição é verificada case-sensitive (A != a).
- Caracteres especiais aceitos: `!@#$%^&*()-+`.
- Espaços são inválidos.

## Próximos passos sugeridos
- Traduzir mensagens para um arquivo de mensagens (i18n)
- Adicionar Swagger/OpenAPI
- Melhorar cobertura de testes para casos de borda
