package blackjack

import blackjack.domain.BlackJack
import blackjack.domain.player.Player
import blackjack.view.InputView
import blackjack.view.ResultView

fun main() {
    val players = InputView.players()
    val blackJack = BlackJack(players = players)

    ResultView.printlnBlackJackInit(players)
    ResultView.printlnPlayersWithCards(players)

    while (!blackJack.isEnd) {
        val hittablePlayers = blackJack.hittablePlayers()
        val player = hittablePlayers.first()
        when (InputView.isHit(player)) {
            true -> hit(blackJack, player)
            false -> player.stay()
        }
    }

    val result = blackJack.result()
    ResultView.printResult(result)
}

fun hit(blackJack: BlackJack, player: Player) {
    player.hit()
    blackJack.hit(player)
        .also { ResultView.printlnPlayerWithCards(player.name, player.cards) }
}
