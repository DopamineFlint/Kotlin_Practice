package Battle_Simulator

abstract class AbstractWeapon(val maxAmmo: Int, val fireType: FireType) {
    private var cal: MutableList<Ammo> = mutableListOf()
    private val weapFireType: FireType = fireType

    fun isReloadNeeded(): Boolean {
        return cal.isEmpty()
    }

    abstract fun createBullet(): Ammo

    fun reload() {
        var reloadCounter = 0
        if (isReloadNeeded()) {
            while (reloadCounter < maxAmmo) {
                cal.add(createBullet())
                reloadCounter++
            }
        }
    }

    fun getAmmoQueue() {
        var ammoQueueCounter = 0
        if (!isReloadNeeded()) {
            if (weapFireType.ammoC == 1) {
                while (ammoQueueCounter < weapFireType.ammoC) {
                    cal.removeAt(cal.size - 1)
                    ammoQueueCounter++
                }
            }

            if (weapFireType.ammoC == 3) {
                while (ammoQueueCounter < weapFireType.ammoC) {
                    if (!isReloadNeeded()) {
                        cal.removeAt(cal.size - 1)
                        ammoQueueCounter++
                    } else {
                        ammoQueueCounter++
                    }
                }
            }
        } else {
            reload()
        }
    }
}