package Battle_Simulator

import kotlin.math.max
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

        val teamFilteredOne = team1.warriorList.filter { !it.isKilled }
        val teamFilteredTwo = team2.warriorList.filter { !it.isKilled }

        println(teamFilteredOne.size)
        println(teamFilteredTwo.size)

        for (i in 0..max(teamFilteredOne.size, teamFilteredTwo.size)) {
            println(i)
            teamFilteredOne.getOrNull(i)?.attack(teamFilteredTwo[Random.nextInt(0, teamFilteredTwo.size)])
            teamFilteredTwo.getOrNull(i)?.attack(teamFilteredOne[Random.nextInt(0, teamFilteredOne.size)])
        }
        bsp.updateStatus(team1.showOverallHealth(), team2.showOverallHealth())
    }
}