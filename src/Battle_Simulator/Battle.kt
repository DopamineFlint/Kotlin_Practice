package Battle_Simulator

import kotlin.random.Random

class Battle(teamSize: Int = 1) {
    private var team1: Team = Team(teamSize)
    private var team2: Team = Team(teamSize)
    var isBattleOver: Boolean = false
    private val bsp: BattleState.Progress = BattleState.Progress()
    private val teamOneWins: BattleState.TeamOneWins = BattleState.TeamOneWins()
    private val teamTwoWins: BattleState.TeamTwoWins = BattleState.TeamTwoWins()
    private val bsDraw: BattleState.Draw = BattleState.Draw()
    private lateinit var bs:BattleState

    init {
        println("Start of the battle")
    }

    fun getBattleState(): BattleState {
        if ((team1.showOverallHealth() > 0) && (team2.showOverallHealth() > 0)) {
            bs = bsp
            nextBattleIteration()
        } else if ((team1.showOverallHealth() > 0) && (team2.showOverallHealth() <= 0)) {
            bs = teamOneWins
            isBattleOver = true
        } else if ((team1.showOverallHealth() <= 0) && (team2.showOverallHealth() > 0)) {
            bs = teamTwoWins
            isBattleOver = true
        } else if ((team1.showOverallHealth() <= 0) && (team2.showOverallHealth() <= 0)) {
            bs = bsDraw
            isBattleOver = true
        }
        return bs
    }

    private fun nextBattleIteration() {
        team1.teamShuffle()
        team2.teamShuffle()

        team1.warriorList.forEach {
            if (!it.isKilled) {
                var i: Int
                while (true) {
                    i = Random.nextInt(0, team2.warriorsCount)

                    if (team2.showOverallHealth() <= 0) {
                        break
                    }

                    if (!team2.warriorList[i].isKilled) {
                        break
                    }
                }
                if (!team2.warriorList[i].isKilled) {
                    it.attack(team2.warriorList[i])
                    bsp.updateStatus(team1.showOverallHealth(), team2.showOverallHealth())
                }
            }
        }

        team2.warriorList.forEach {
            if (!it.isKilled) {
                var i: Int
                while (true) {
                    i = Random.nextInt(0, team1.warriorsCount)

                    if (team1.showOverallHealth() <= 0) {
                        break
                    }

                    if (!team1.warriorList[i].isKilled) {
                        break
                    }
                }
                if (!team1.warriorList[i].isKilled) {
                    it.attack(team1.warriorList[i])
                    bsp.updateStatus(team1.showOverallHealth(), team2.showOverallHealth())
                }
            }
        }
    }
}