package Battle_Simulator

sealed class FireType(val ammoC: Int) {

    class Semi(ammoC: Int = 1): FireType(ammoC) //

    class Burst(ammoC: Int = 3): FireType(ammoC)
}