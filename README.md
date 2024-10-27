# FornecedorApp

FornecedorApp é uma aplicação web desenvolvida com Spring Boot e Thymeleaf para gerenciamento de fornecedores. Permite o cadastro, listagem, edição e exclusão de fornecedores.

## Tecnologias Utilizadas

- Spring Boot
- Spring Data JPA
- Thymeleaf
- MySQL
- Bootstrap

## Funcionalidades

- Cadastro de fornecedores
- Listagem de fornecedores
- Edição de fornecedores
- Exclusão de fornecedores

## Pré-requisitos

Antes de começar, você precisa ter instalado:

- Java 17 ou superior
- Maven
- MySQL

## Configuração do Banco de Dados

1. **Instalação do MySQL**
   - Certifique-se de que o MySQL está instalado e em execução.

2. **Criar um Banco de Dados**
   - Crie um banco de dados chamado com o nome que preferir.

   ```sql
   CREATE DATABASE "nomeDoSeuBancoDeDados";

## Configurar as Credenciais

  spring.datasource.url=jdbc:mysql://localhost:3306/"nomeDoSeuBancoDeDados"
  spring.datasource.username=seu_usuario
  spring.datasource.password=sua_senha
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.show-sql=true

## Como Executar a Aplicação

1. Clone este repositório: bash
  git clone https://github.com/seu_usuario/"nomeDoSeuBancoDeDados".git

2. Navegue até o diretório do projeto: bash
  cd "nomeDoSeuBancoDeDados"

3. Compile e execute a aplicação: bash
  mvn spring-boot:run

4. Acesse a aplicação em http://localhost:8080/"nomeDoSeuBancoDeDados".

## Estrutura do Projeto
nomeDoSeuBancoDeDados/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── kaspperAcad/
│   │   │           └── empresa/
│   │   │               ├── controller/
│   │   │               ├── model/
│   │   │               ├── repository/
│   │   │               └── EmpresaApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── templates/
│   └── test/
└── pom.xml

## Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request.
