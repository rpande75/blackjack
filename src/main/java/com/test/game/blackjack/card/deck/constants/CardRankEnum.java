package com.test.game.blackjack.card.deck.constants;



public enum CardRankEnum {
	
	ACE(1),
	TWO(2),
	THREE(3),
	FOUR(4),
	FIVE(5),
	SIX(6),
	SEVEN(7),
	EIGHT(8),
	NINE(9),
	TEN(10),
	JACK(10),
	QUEEN(10),
	KING(10);
	
	private int rank;

	private CardRankEnum(int rank) {
		this.rank = rank;
	}

	public int getRank() {
		return rank;
	}
	
	
}
