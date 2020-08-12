package Battle_Simulator

sealed class BattleState {
    abstract var message: String

    class Progress: BattleState() {
        private var tHealth1: Int = 0
        private var tHealth2: Int = 0
        override var message: String = "team1 health - ${tHealth1}, team2 health - $tHealth2"

        fun updateStatus(tH1: Int, tH2: Int) {
            message = "team1 health - $tH1, team2 health - $tH2"
        }
    }

    class TeamOneWins : BattleState() {
        override var message: String = "First team WINS!"
    }

    class TeamTwoWins : BattleState() {
        override var message: String = "Second team WINS!"
    }

    class Draw : BattleState() {
        override var message: String = "DRAW!"
    }
}