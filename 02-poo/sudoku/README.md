# Sudoku Console (Java) 🔢

**Projeto de Sudoku em linha de comando, desenvolvido com foco em princípios de POO e boas práticas em Java.**

---

##  Resumo

Jogo de Sudoku simples executado no terminal. Permite iniciar um novo jogo, inserir/remover números, visualizar o tabuleiro e verificar status (com validação de solução e detecção de erros).

---

## ✅ Funcionalidades

- Iniciar um novo jogo (carrega um template por posição ou usa valores vazios)
- Inserir e remover números em posições válidas
- Exibir o tabuleiro no formato legível no terminal
- Verificar se o jogo contém erros ou foi finalizado corretamente
- Resetar (limpar) o jogo

---

## 🧰 Tecnologias e conceitos demonstrados

- Java (sem frameworks) — módulos organizados por package
- Programação Orientada a Objetos (encapsulamento, responsabilidade única)
- Uso de Streams, Collections e API de utilitários
- Tratamento de entrada e validação básica

---

## 📁 Estrutura do projeto

- `src/` — código fonte (package `br.com.dio`)
  - `Main.java` — CLI e fluxo do jogo
  - `model/` — `Board`, `Space`, `GameStatusEnum`
  - `util/` — `BoardTemplate` (formatação do tabuleiro)
- `bin/` — saída da compilação

---

### Iniciar jogo com posições pré-definidas (opcional)
Você pode passar argumentos para pré-configurar posições no formato `"<col>,<row>;<expected>,<fixed>"`.
Exemplo:

```powershell
java -cp bin br.com.dio.Main 0,0;5,true 0,1;3,true 8,8;9,true
```

Cada argumento mapeia `"col,row" -> "expected,fixed"` (p.ex. `5,true`). Se nenhuma configuração é passada, o jogo inicia com espaços vazios.

---

### O que são `expected` e `fixed` 🔎

- `expected` (int) — o **valor correto** que aquela célula deve ter no tabuleiro final. Use `0` para representar um espaço vazio.
- `fixed` (boolean) — indica se a célula é **fixa** (fornecida pelo puzzle) e **não pode ser alterada** pelo jogador. `true` = fixa, `false` = editável.

Exemplo: `0,0;5,true` → coluna 0, linha 0, valor esperado `5` e posição fixa = `true`.

---

## 🧪 Uso (exemplo de comandos no menu)

- `1` - Iniciar um novo Jogo
- `2` - Colocar um novo número
- `3` - Remover um número
- `4` - Visualizar jogo atual
- `5` - Verificar status do jogo
- `6` - Limpar jogo
- `7` - Finalizar jogo
- `8` - Sair

---

**Autor:** Sergio Manso 💼

