package blackjack.view

import blackjack.domain.blackjack.BlackJackResult
import blackjack.domain.blackjack.DealerResult
import blackjack.domain.blackjack.ParticipantResult
import blackjack.domain.blackjack.PlayerResult
import blackjack.domain.card.Card
import blackjack.domain.player.Dealer
import blackjack.domain.player.Player
import blackjack.domain.score.Match

object ResultView {

    fun printlnBlackJackInit(players: List<Player>, dealer: Dealer) {
        println("${dealer.name}와 ${players.map(Player::name).joinToString(",")}에게 2장의 나누었습니다.")
    }

    fun printlnPlayersWithCards(players: List<Player>, dealer: Dealer) {
        printlnPlayerWithCards(dealer.name, dealer.cards.take(1))
        players.forEach { player ->
            printlnPlayerWithCards(player.name, player.cards)
        }.also { println() }
    }

    fun printlnPlayerWithCards(name: String, cards: List<Card>) {
        printPlayerWithCards(name, cards).also { println() }
    }

    fun printResult(result: BlackJackResult) {
        println()
        val dealer = result.dealerResult.participantResult
        printParticipantWithScore(dealer)
        result.playerResults.forEach {
            printParticipantWithScore(it.participantResult)
        }.also { println() }
    }

    private fun printParticipantWithScore(participantResult: ParticipantResult) {
        printPlayerWithCards(participantResult.name, participantResult.cards)
        println(" - 결과: ${participantResult.score.value}")
    }

    fun printMatch(result: BlackJackResult) {
        println("## 최종 승패")
        printDealerMatch(result.dealerResult)
        printPlayersMatch(result.playerResults)
    }

    private fun printDealerMatch(dealerResult: DealerResult) {
        val matches = dealerResult.matches
        val win = matches.count { it == Match.WIN }
            .let { if (it > 0) "$it${Match.WIN.description} " else "" }
        val draw = matches.count { it == Match.DRAW }
            .let { if (it > 0) "$it${Match.DRAW.description} " else "" }
        val lose = matches.count { it == Match.LOSE }
            .let { if (it > 0) "$it${Match.LOSE.description} " else "" }

        println("${dealerResult.participantResult.name} $win$draw$lose")
    }

    private fun printPlayersMatch(playerResults: List<PlayerResult>) {
        playerResults.forEach {
            println("${it.participantResult.name}: ${it.match.description}")
        }
    }

    fun printDealerPlay(dealerAddCount: Int) {
        println()
        if (dealerAddCount > 0) {
            println("딜러는 16이하라 ${dealerAddCount}장의 카드를 더 받았습니다.")
        } else {
            println("딜러는 17이상이라 추가 카드를 받지 않았습니다.")
        }
    }
}

private fun printPlayerWithCards(name: String, cards: List<Card>) {
    print("${name}카드: ${cards.joinToString(", ") { "${it.denomination.name}${it.suit.description}" }}")
}
