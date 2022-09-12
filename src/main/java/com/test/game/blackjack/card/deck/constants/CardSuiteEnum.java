package com.test.game.blackjack.card.deck.constants;



public enum CardSuiteEnum {
	
	CLUBS("clubs"),
	DIAMOND("Diamonds"),
	HEARTS("Hearts"),
	SPADES("Spades");
	
	private String suite;

	private CardSuiteEnum(String suite) {
		this.suite = suite;
	}

	public String getSuite() {
		return suite;
	}
	
}
