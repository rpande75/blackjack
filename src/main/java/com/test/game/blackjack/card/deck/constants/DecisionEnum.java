package com.test.game.blackjack.card.deck.constants;

public enum DecisionEnum {
	
//	We can add support to other decision such as double down, split, surrender as well. but here I'm limiting scope to Hit and stand

	HIT("hit"),
	STAND("stand");
	
	private String decison;

	private DecisionEnum(String decison) {
		this.decison = decison;
	}

	public String getDecison() {
		return decison;
	}
}
