package com.test.game.blackjack.card.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.test.game.blackjack.card.deck.constants.CardRankEnum;
import com.test.game.blackjack.card.deck.constants.CardSuiteEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeckOfCard {
	private List<Card> deck;
	
	public DeckOfCard() {
		deck = new ArrayList<>();
		for (CardSuiteEnum cardTypeEnum : CardSuiteEnum.values()) {
			for (CardRankEnum cardRankEnum : CardRankEnum.values()) {
				deck.add(new Card(cardTypeEnum, cardRankEnum));
			}
		}
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	public Card drawCard() {
	    return deck.remove(0);
	}

}
