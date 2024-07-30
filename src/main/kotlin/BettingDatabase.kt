/*
   Dummy database representing a singleton for a database connector
*/
object BettingDatabase {
    private val users = mutableListOf<User>()
    private val games = mutableListOf<Game>()
    private val bets = mutableListOf<Bet>()

    fun addUser(user: User) {
        users.add(user)
    }

    fun addGame(game: Game) {
        games.add(game)
    }

    fun addBet(bet: Bet) {
        bets.add(bet)
    }

    fun getUsers(): List<User> = users

    fun getGames(): List<Game> = games

    fun getBets(): List<Bet> = bets
}
