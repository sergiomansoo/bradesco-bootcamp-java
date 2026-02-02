## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

---

## Sobre este Projeto

Exemplo de um sistema bancário simples para praticar POO em Java. Implementa clientes, contas (corrente e poupança), histórico de transações, transferências e geração de extratos.

## Como executar

1. Compile: `javac -d bin src\*.java`
2. Execute: `java -cp bin Main`

## Funcionalidades adicionadas

- Criação de `Cliente`, `ContaCorrente` e `ContaPoupanca`
- Histórico de transações (extrato)
- Transferências entre contas
- Rendimento da poupança (método `renderJuros`)
- Relatório simples do `Banco`
