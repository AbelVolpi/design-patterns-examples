data class Bet(
    val bettor: User,
    val amount: Double,
    val game: Game,
    val chosenOdd: Odd
) {
    class Builder(
        private var bettor: User? = null,
        private var amount: Double? = null,
        private var game: Game? = null,
        private var chosenOdd: Odd? = null
    ) {
        fun bettor(bettor: User) = apply { this.bettor = bettor }
        fun amount(amount: Double) = apply { this.amount = amount }
        fun game(game: Game) = apply { this.game = game }
        fun chosenOdd(chosenOdd: Odd) = apply { this.chosenOdd = chosenOdd }
        fun build(): Bet {
            if (bettor == null || amount == null || game == null || chosenOdd == null) {
                throw IllegalArgumentException("Bet details are not fully provided")
            }
            return Bet(bettor!!, amount!!, game!!, chosenOdd!!)
        }
    }
}
