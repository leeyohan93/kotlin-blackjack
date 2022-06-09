package blackjack.domain.player

class Players(val players: List<Player>) {

    init {
        require(players.isNotEmpty()) {
            "플레이어는 한 명 이상이어야 합니다."
        }
    }

    fun addTwoCard(dealer: Dealer) {
        players.forEach { player ->
            repeat(2) { dealer.giveCard(player) }
        }
    }

    fun hittablePlayers(): List<Player> {
        return players.filterNot(Player::isEnd)
    }

    fun isEnd(): Boolean {
        return players.all(Player::isEnd)
    }

    fun contains(player: Player): Boolean {
        return players.contains(player)
    }
}
