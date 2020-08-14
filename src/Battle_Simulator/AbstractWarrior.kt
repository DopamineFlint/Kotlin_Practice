package Battle_Simulator

import kotlin.random.Random

abstract class AbstractWarrior(maxH: Int, ahc: Int, acc: Int, weap: AbstractWeapon): Warrior {
    override var isKilled: Boolean = false
    override var avoidHitChance: Int = ahc
    var currentHP: Int = maxH
    private val accuracy: Int = acc

    private var weapon: AbstractWeapon = weap

    override fun attack(enemy: Warrior) {
        if (weapon.isReloadNeeded()) {
            weapon.reload()
        } else {
            weapon.getAmmoQueue()
            val acAvoid: Int = accuracy - enemy.avoidHitChance
            if (acAvoid < Random.nextInt(0, 100)) {
                enemy.getHit(weapon.createBullet().currentDamageCalculation()) //.currentDamageCalculation()
            }
        }
    }

    override fun getHit(hit: Int) {
        currentHP -= hit
        if (currentHP <= 0) {
            currentHP = 0
            isKilled = true
        }
    }
}