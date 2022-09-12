package com.test.game.blackjack.card.deck;

import com.test.game.blackjack.card.deck.constants.CardRankEnum;
import com.test.game.blackjack.card.deck.constants.CardSuiteEnum;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Card {
	
	private CardSuiteEnum cardSuiteEnum;
	
	private CardRankEnum cardRankEnum;
	
	public Card(CardSuiteEnum cardSuiteEnum, CardRankEnum cardRankEnum) {
		this.cardSuiteEnum = cardSuiteEnum;
		this.cardRankEnum = cardRankEnum;
	}
}
