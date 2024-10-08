class BettingSystem {

    fun registerUser(name: String): User {
        val user = User(name)
        BettingDatabase.addUser(user)
        return user
    }

    fun createGame(
        teamA: String,
        teamB: String,
        oddWinAValue: Double,
        oddWinBValue: Double,
        oddDrawValue: Double
    ): Game {
        val oddWinA = Odd("WinA", oddWinAValue)
        val oddWinB = Odd("WinB", oddWinBValue)
        val oddDraw = Odd("Draw", oddDrawValue)

        val game = Game(teamA, teamB, oddWinA, oddWinB, oddDraw)
        BettingDatabase.addGame(game)
        return game
    }

    fun placeBet(bettor: User, amount: Double, game: Game, chosenOdd: Odd) {
        val bet = Bet.Builder()
            .bettor(bettor)
            .amount(amount)
            .game(game)
            .chosenOdd(chosenOdd)
            .build()
        BettingDatabase.addBet(bet)
        println("Bet placed: $bet")
    }

    fun favoriteGame(user1: User, game1: Game) {
        user1.favoriteGame(game1)
    }

    fun updateOdds(game: Game, oddWinA: Double, oddWinB: Double, oddDraw: Double) {
        game.setOddWinA(oddWinA)
        game.setOddWinB(oddWinB)
        game.setOddDraw(oddDraw)
        game.notifyUsersObservers()
    }

    fun printAllGames() {
        println("\nGames:")
        println("-----------------------------------------------------------------")
        println("| Team A         | Team B         | Odd WinA | Odd WinB | Draw  |")
        println("-----------------------------------------------------------------")
        val games = BettingDatabase.getGames()
        for (game in games) {
            println(
                "| ${game.teamA.padEnd(15)} | ${game.teamB.padEnd(13)} | ${
                    game.getOddWinA().value.toString().padEnd(8)
                } | ${game.getOddWinB().value.toString().padEnd(8)} | ${game.getOddDraw().value.toString().padEnd(5)} |"
            )
        }
        println("-----------------------------------------------------------------")
    }

    fun printAllBets() {
        println("\nBets:")
        println("------------------------------------------------------------------------")
        println("| User           | Game                          | Chosen Odd | Amount |")
        println("------------------------------------------------------------------------")
        val bets = BettingDatabase.getBets()
        for (bet in bets) {
            val gameInfo = "${bet.game.teamA} vs ${bet.game.teamB}"
            println(
                "| ${bet.bettor.name.padEnd(14)} | ${gameInfo.padEnd(29)} | ${
                    bet.chosenOdd.name + " - " + bet.chosenOdd.value
                } | ${bet.amount.toString().padEnd(6)} |"
            )
        }
        println("------------------------------------------------------------------------")
    }

    fun printAllUsers() {
        println("\nUsers:")
        println("------------------")
        println("| Name            |")
        println("------------------")
        val users = BettingDatabase.getUsers()
        for (user in users) {
            println("| ${user.name.padEnd(15)} |")
        }
        println("------------------")
    }
}
