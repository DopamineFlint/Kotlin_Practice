package Battle_Simulator

import kotlin.random.Random

enum class Ammo(val damage: Int, val criticalChance: Int, val coefficient: Int) {
    STANDARD(15, 5, 2),
    HP(35, 15, 3);

    private fun critChanceCheck(): Int {
        val random: Int = Random.nextInt(100)
        return if (random <= criticalChance) {
            damage * coefficient
        } else {
            damage
        }
    }

    fun currentDamageCalculation(): Int {
        return critChanceCheck()
    }
}