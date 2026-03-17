# Password Validator API

API REST desenvolvida em Java com Spring Boot para validação de senhas
com base em regras definidas no desafio técnico.

A API recebe uma senha via requisição HTTP e retorna um boolean
indicando se a senha é válida ou não.


## Tecnologias utilizadas

- Java 17
- Spring Boot
- Maven
- JUnit 5
- Mockito
- MockMvc


## Como executar o projeto

### Pré-requisitos

- Java 17+
- Maven

### Passos

1. Clonar o repositório

```bash
git clone https://github.com/AdrieliKet/PasswordValidator.git
```

2. Entrar na pasta do projeto

```bash
cd PasswordValidator
```

3. Executar a aplicação

```bash
mvn spring-boot:run
```

## Endpoint

```http request
POST /api/v1/password/validate
```

### Request

```json
{
 "password": "AbTp9!fok"
}
```

### Response

```json
{
 "valid": true
}
```

## Regras de validação da senha

Uma senha é considerada válida quando atende aos seguintes critérios:

- Possui no mínimo 9 caracteres
- Contém ao menos um dígito
- Contém ao menos uma letra minúscula
- Contém ao menos uma letra maiúscula
- Contém ao menos um caractere especial (!@#$%^&*()-+)
- Não possui caracteres repetidos
- Não contém espaços em branco

## Premissas

Durante a implementação foram consideradas as seguintes premissas:

- Caso a senha seja `null`, ela é considerada inválida.
- Caso a senha esteja vazia, ela é considerada inválida.
- A API sempre retorna `200 OK` com o campo `valid` indicando o resultado da validação.


## Arquitetura da solução

O projeto foi estruturado seguindo uma separação de responsabilidades em camadas:

- Controller: responsável por expor o endpoint da API
- Service: responsável por orquestrar a validação
- Validator: responsável pelas regras de validação da senha
- DTOs: utilizados para comunicação entre API e cliente


## Decisões de design

Algumas decisões foram tomadas visando manter o código simples, testável e extensível:

- A lógica de validação foi isolada em uma classe `PasswordValidator`, respeitando o princípio de responsabilidade única (SRP).
- O `PasswordValidationService` atua como camada intermediária entre controller e regras de validação.
- DTOs foram utilizados para evitar expor diretamente objetos internos da aplicação.
- A API foi versionada (`/api/v1`) para permitir evolução futura sem quebrar clientes existentes.


## Testes

O projeto possui testes unitários e de integração.

### Testes unitários
- PasswordValidatorTest
- PasswordValidationServiceTest

Responsáveis por validar as regras de negócio.

### Testes de integração
- PasswordControllerTest

Responsável por validar o comportamento da API utilizando MockMvc.


## Possíveis melhorias

Algumas melhorias que poderiam ser implementadas em um cenário de produção:

- Adicionar tratamento global de exceções
- Adicionar validação mais robusta com Bean Validation
- Implementar documentação da API com OpenAPI / Swagger
- Adicionar métricas e logs estruturados

