package com.test.game.blackjack.dealer;

import com.test.game.blackjack.card.deck.constants.DecisionEnum;
import com.test.game.blackjack.dealer.strategy.Strategy;
import com.test.game.blackjack.player.Player;

public class Dealer extends Player {

	private Strategy strategy;

	public Dealer(String name, Strategy strategy) {
		super.name = name;
		this.strategy = strategy;
	}
	
	
	public boolean shouldHit() {
		boolean shouldHit = false;
		if (DecisionEnum.HIT == strategy.apply(value())) {
			shouldHit =  true;
		}
		return shouldHit;
	}
	
}
