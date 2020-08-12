package Battle_Simulator

abstract class AbstractWeapon(val maxAmmo: Int, val fireType: FireType) {
    private var x: Int = 0
    private var cal: MutableList<Ammo> = mutableListOf()
    private val weapFireType: FireType = fireType

    fun isReloadNeeded(): Boolean {
        return cal.isEmpty()
    }

    abstract fun createBullet(): Ammo

    fun reload() {
        if (isReloadNeeded()) {
            while (x < maxAmmo) {
                cal.add(createBullet())
                x++
            }
            x = 0
        }
    }

    fun getAmmoQueue() {
        if (!isReloadNeeded()) {
            if (weapFireType.ammoCount == 1) {
                while (x < weapFireType.ammoCount) {
                    cal.removeAt(cal.size - 1)
                    x++
                }
            }

            if (weapFireType.ammoCount == 3) {
                while (x < weapFireType.ammoCount) {
                    if (!isReloadNeeded()) {
                        cal.removeAt(cal.size - 1)
                        x++
                    } else {
                        x++
                    }
                }
            }
        } else {
            reload()
        }
        x = 0
    }
}