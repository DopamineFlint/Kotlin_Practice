package Battle_Simulator

import kotlin.random.Random

enum class Ammo(private val damage: Int, private val criticalChance: Int, private val coefficient: Int) { //стоит ли делать свойства приватными?
    STANDARD(15, 5, 2),
    HP(35, 15, 3);

    private fun critChanceCheck(): Int {
        val random: Int = Random.nextInt(100)
        return if (random <= STANDARD.criticalChance) {
            STANDARD.damage * STANDARD.coefficient
        } else {
            STANDARD.damage
        }
    }

    fun currentDamageCalculation(): Int {
        return critChanceCheck()
    }
}