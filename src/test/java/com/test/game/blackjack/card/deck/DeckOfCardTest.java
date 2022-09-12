package com.test.game.blackjack.card.deck;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.test.game.blackjack.card.deck.constants.CardRankEnum;
import com.test.game.blackjack.card.deck.constants.CardSuiteEnum;

public class DeckOfCardTest {
	
	@Test
	public void deckOfCard() {
		DeckOfCard deck = new DeckOfCard();
		
		assertEquals(52, deck.getDeck().size());
	}
	
	@Test
	public void drawCard() {
		DeckOfCard deck = new DeckOfCard();
		for (CardSuiteEnum cardTypeEnum : CardSuiteEnum.values()) {
			for (CardRankEnum cardRankEnum : CardRankEnum.values()) {
				assertEquals(new Card(cardTypeEnum, cardRankEnum), deck.drawCard());
			}
		}
		assertEquals(0, deck.getDeck().size());
	}
}
