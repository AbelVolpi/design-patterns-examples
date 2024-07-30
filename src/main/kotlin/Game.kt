class Game(
    val teamA: String,
    val teamB: String,
    private var oddWinA: Odd,
    private var oddWinB: Odd,
    private var oddDraw: Odd
) {
    fun getOddWinA() = oddWinA

    fun getOddWinB() = oddWinB

    fun getOddDraw() = oddDraw

    fun setOddWinA(oddWinAValue: Double) {
        this.oddWinA.value = oddWinAValue
    }

    fun setOddWinB(oddWinBValue: Double) {
        this.oddWinB.value = oddWinBValue
    }

    fun setOddDraw(oddDraw: Double) {
        this.oddDraw.value = oddDraw
    }

    private val gameObservers = mutableListOf<GameObserver>()

    fun addObserver(gameObserver: GameObserver) {
        gameObservers.add(gameObserver)
    }

    fun notifyUsersObservers() {
        for (observer in gameObservers) {
            observer.onGameUpdated(this)
        }
    }
}

data class Odd(
    val name: String,
    var value: Double
)