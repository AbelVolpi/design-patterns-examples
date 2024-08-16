# Documentação

O sistema fictício escolhido é um sistema de apostas que terá os seguintes objetos:

- Game
- User
- Bet

E as seguintes opções:

- Create game,
- Register user,
- Place bet
- Update game odds
- Favorite game

Os padrões de projetos serão aplicados das seguintes formas:

### Builder:

O objeto `Bet` será criado utilizando esse padrão, onde será possível criar apostas com a seguinte estrutura:

```
val bet = Bet.Builder()
   .apostador(apostador)
   .montante(montante)
   .jogo(jogo)
   .chosenOdd(chosenOdd)
   .construir()
```

Isso permite que esse objeto complexo possa ser criado através de um passo a passo.

### Singleton

O `BettingDatabase` armazena os dados, mas ele representa um database connector, que seria recomendado ter apenas uma
única instância no projeto para evitar a criação de múltiplas conexões que gerariam inconsistências. Sendo assim, criando um único objeto desse tipo, que vai ser compartilhado durante todo o ciclo de vida da aplicação, como uso recomendado para esse padrão.

### Facade

É aplicada no `BettingSystem`, que atua como uma abstração para a lógica de criação e
manipulação dos objetos do sistema.

<img width="60%" src="img1.png" />


### Observer

É aplicado entre as classes `Game` e `Bet`, através da interface `GameObserver`. O objeto `Game` possui uma função
função `addObserver`, que espera por um objeto `GameObserver` e o salva em uma lista (o objeto `User` implementa esta
interface, então ele pode ser adicionado como um observador). Quando algum valor de odd é alterado, o `Game` itera sua lista e notifica todos os objetos `User` ligados.

