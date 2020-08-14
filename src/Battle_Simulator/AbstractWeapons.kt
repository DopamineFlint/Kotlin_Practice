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
            if (weapFireType.ammoCount == 1) {
                while (ammoQueueCounter < weapFireType.ammoCount) {
                    cal.removeAt(cal.size - 1)
                    ammoQueueCounter++
                }
            }

            if (weapFireType.ammoCount == 3) {
                while (ammoQueueCounter < weapFireType.ammoCount) {
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