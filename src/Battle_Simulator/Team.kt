package Battle_Simulator

import Battle_Simulator.warriors.CommonWarrior
import Battle_Simulator.warriors.EpicWarrior
import Battle_Simulator.warriors.RareWarrior
import java.util.Collections.shuffle
import kotlin.random.Random

class Team(var warriorsCount: Int = 1) {
    var warriorList: MutableList<AbstractWarrior> = mutableListOf()

    init {
        teamRefill()
    }

    fun teamShuffle() {
        shuffle(warriorList)
    }

    private fun teamRefill() {
        for (counter in 1..warriorsCount) {
            when (Random.nextInt(1, 4)) {
               1 -> warriorList.add(CommonWarrior())
               2 -> warriorList.add(RareWarrior())
               3 -> warriorList.add(EpicWarrior())
            }
        }
        teamShuffle()
    }

    fun showOverallHealth(): Int {
        var overallHealth = 0
        for (item in warriorList) {
            overallHealth += item.currentHP
        }
        return overallHealth
    }
}