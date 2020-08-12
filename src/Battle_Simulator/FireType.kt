package Battle_Simulator

sealed class FireType(private val ammoC: Int) {
    var ammoCount: Int = ammoC

    class Semi(ammoC: Int = 1): FireType(ammoC)

    class Burst(ammoC: Int = 3): FireType(ammoC)
}