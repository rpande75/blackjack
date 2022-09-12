package com.test.game.blackjack.dealer.strategy.basic;

import java.util.List;

import com.test.game.blackjack.card.deck.constants.DecisionEnum;
import com.test.game.blackjack.dealer.strategy.Strategy;
import com.test.game.blackjack.player.Player;

public class StrategySixteen implements Strategy {
	
	private List<Player> players;
	
	
	public StrategySixteen(List<Player> players) {
		this.players = players;
	}
	
	
	@Override
	public DecisionEnum apply(int dealerTotalValue) {
		DecisionEnum decisionEnum = DecisionEnum.STAND;
		
		long numberOfWinningPlayers = players.stream().filter(player -> player.value() > dealerTotalValue).count();
		
//		if all players wining against dealer, then nothing to lose so always HIT
		if (numberOfWinningPlayers == players.size() || dealerTotalValue <= 16) {
			decisionEnum =  DecisionEnum.HIT;
		}
		return decisionEnum;
	}
	
}
