# Spring Data JPA Exception Handler

Um projeto educacional que demonstra boas práticas no desenvolvimento de APIs REST com Spring Boot, focando em tratamento de exceções e estruturação adequada de respostas de erro.

## 📋 Descrição

Implementação de uma API REST que gerencia informações de códigos postais (IBGE) com tratamento robusto de exceções. O projeto exemplifica como estruturar uma aplicação Spring Boot de forma escalável e mantível.

## 🎯 Objetivos

- Demonstrar padrões de desenvolvimento com Spring Boot
- Implementar tratamento centralizado de exceções
- Estruturar respostas padronizadas de erro
- Aplicar conceitos de REST API
- Utilizar Spring Data JPA com banco de dados PostgreSQL

## 🛠️ Tecnologias Utilizadas

- **Java 8**
- **Spring Boot 2.5.4**
- **Spring Data JPA**
- **PostgreSQL**
- **Maven**

## 📁 Estrutura do Projeto
src/main/java/com/sergiomansoo/
├── controller/
│ └── CodigoPostalController.java # Endpoints da API
├── handler/
│ ├── BusinessException.java # Exceção customizada
│ └── ResponseError.java # Modelo de resposta de erro
├── model/ # Entidades JPA
├── repository/ # Interfaces de acesso a dados
└── SpringDataJpaExceptionHandlerApplication.java

💡 Aprendizados Principais
Exception Handling: Implementação de handlers globais com @ControllerAdvice
Validação: Uso de anotações de validação do Spring
REST API: Padrões RESTful de design de API
Spring Data JPA: Operações CRUD com JPA
Segurança: Tratamento adequado de mensagens de erro

📚 Endpoints
Obter Cidade por Código IBGE
Parâmetros:

ibge (string): Código IBGE de 7 dígitos
Resposta de sucesso (200):

Resposta de erro (400):

{
  "timestamp": "2026-02-12T10:30:00",
  "status": 400,
  "error": "Bad Request",
  "message": "Não localizamos nenhuma cidade com o código informado.",
  "path": "/cep/9999999"
}

## 🚀 Como Executar

### Pré-requisitos
- Java 8+
- Maven 3.6+
- PostgreSQL 12+

### Passo a passo
1. Clone o repositório
2. Configure o banco de dados em src/main/resources/application.properties
3. Execute o projeto
