fun main() {
    val player = Player("Madrigal")
    player.castFireball()
    //Aura
    val auraColor = player.auraColor
    //com.bignerdranch.nyethack.Player Status
    printPlayerStatus(player)
    //Drunk Status
    val numFireballs =(2..10).random()
    printDrunkStatus(numFireballs)
}

private fun printPlayerStatus(player: Player) {
    println("光環顏色：${player.auraColor}" + "    走運嗎？${if (player._isBlessed) "是的" else "很背"}")
    println("${player.name} ${player.healthStatus}")
}

private fun printDrunkStatus(numFireballs: Int) {
    println("酒醉程度：${drunkStatus(numFireballs)}")
}

private fun drunkStatus(numFireballs:Int,
                        drunkness:Int=numFireballs* 5)=
    when (drunkness) {
        in 1..10 -> "微醺"
        in 11..20 -> "微醉"
        in 21..30 -> "醉了"
        in 31..40 -> "大醉"
        in 31..50 -> "爛醉如泥"
        else -> null
    }
