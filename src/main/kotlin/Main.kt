fun main(args: Array<String>) {
    val system = BettingSystem()
    // Create users
    val user1 = system.registerUser("Alice")
    val user2 = system.registerUser("Bob")

    // Create games
    val game1 = system.createGame("Santos", "Corinthians", 3.0, 1.5, 1.1)
    val game2 = system.createGame("Botafogo", "Flamengo", 2.0, 2.0, 1.1)
    val game3 = system.createGame("Fluminense", "Vasco", 1.5, 3.0, 1.1)

    // Favorite games
    system.favoriteGame(user1, game1)

    // Change Odds and notify users
    system.updateOdds(game1, 1.3, 3.0, 3.0)

    // Create bets
    system.placeBet(user1, 100.0, game1, game1.getOddWinA())
    system.placeBet(user2, 50.0, game1, game1.getOddWinB())

    // Print all
    system.printAllBets()
    system.printAllGames()
    system.printAllUsers()
}