class User(
    val name: String
) : GameObserver {

    fun favoriteGame(game: Game) {
        game.addObserver(this)
    }

    override fun onGameUpdated(game: Game) {
        println("User $name notified: Odds changed in game between ${game.teamA} and ${game.teamB}. New odds: WinA ${game.getOddWinA().value}, WinB ${game.getOddWinB().value}, Draw ${game.getOddDraw().value}")
    }
}