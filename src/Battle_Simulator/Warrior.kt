package Battle_Simulator

interface Warrior {
    var isKilled: Boolean
    var avoidHitChance: Int

    fun attack(enemy: Warrior)

    fun getHit(hit: Int)
}