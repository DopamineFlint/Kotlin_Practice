package Battle_Simulator

import java.util.*

fun main() {
    print("Input size team -> ")
    val scan = Scanner(System.`in`)
    val teamSize: Int = scan.nextLine().trim().toInt()

    val battle = Battle(teamSize)
    while (!battle.isBattleOver) {
        println(battle.getBattleState().message)
    }
}