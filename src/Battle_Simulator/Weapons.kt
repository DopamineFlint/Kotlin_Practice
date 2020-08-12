package Battle_Simulator

object Weapons {

    val spas12 = object: AbstractWeapon(
            maxAmmo = 8,
            fireType = FireType.Semi()) {
        override fun createBullet(): Ammo {
            return Ammo.STANDARD
        }
    }

    val beretta93R = object: AbstractWeapon(
            maxAmmo = 12,
            fireType = FireType.Burst()) {
        override fun createBullet(): Ammo {
            return Ammo.HP
        }
    }
}