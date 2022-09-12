package com.test.game.blackjack.dealer.strategy;

import com.test.game.blackjack.card.deck.constants.DecisionEnum;

public interface Strategy {

	public DecisionEnum apply(int totalValue);
}
