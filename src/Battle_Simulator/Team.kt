package Battle_Simulator

import Battle_Simulator.warriors.CommonWarrior
import Battle_Simulator.warriors.EpicWarrior
import Battle_Simulator.warriors.RareWarrior
import java.util.Collections.shuffle
import kotlin.random.Random

class Team(var warriorsCount: Int = 1) {
    private var x: Int = 0
    private var random: Int = 0
    var warriorList: MutableList<AbstractWarrior> = mutableListOf()
    private var overallHealth: Int = 0

    init {
        teamRefill()
    }

    fun teamShuffle() {
        shuffle(warriorList)
    }

    private fun teamRefill() {
        while (x < warriorsCount) {
            random = Random.nextInt(1, 4)
            when (random) {
               1 -> warriorList.add(CommonWarrior())
               2 -> warriorList.add(RareWarrior())
               3 -> warriorList.add(EpicWarrior())
            }
            x++
        }
        teamShuffle()
        x = 0
    }

    fun showOverallHealth(): Int {
        overallHealth = 0
        for (item in warriorList) {
            overallHealth += item.currentHP
        }
        return overallHealth
    }
}