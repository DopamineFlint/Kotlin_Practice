package Battle_Simulator

fun main() {
    print("Input size team -> ")
    val line = readLine()?.toInt() ?: 10

    val battle = Battle(line)
    while (!battle.isBattleOver) {
        println(battle.getBattleState().message)
    }
}