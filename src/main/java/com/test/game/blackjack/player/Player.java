package com.test.game.blackjack.player;

import java.util.ArrayList;
import java.util.List;

import com.test.game.blackjack.card.deck.Card;
import com.test.game.blackjack.card.deck.constants.CardRankEnum;

public class Player {
	
	protected String name;
	protected List<Card> cards;
	
	public Player() {
		
	}
	public Player(String name) {
		this.name = name;
	}
	
	
	public void insert(Card card) {
		if (null == cards) {
			cards = new ArrayList<>();
		}
		cards.add(card);
	}
	
	public int value() {
		int value = 0;
		int aceCounter = 0;
		for (Card card : cards) {
			if (card.getCardRankEnum() == CardRankEnum.ACE) {
				aceCounter++;
			}
			else {
				value += card.getCardRankEnum().getRank();
			}
		}
		
//		by default count value 1 for each ace
		value = value + aceCounter;
		
//		Determine depending on total value of other cards if ace's value should be considered as 1 or 11.
		while (aceCounter > 0) {
			if (value + 10 <= 21) {
				value = value + 10;
			}
			aceCounter--;
		}
		return value;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isCardDealt() {
		boolean isCardDealt = false;
		if (null != cards && cards.size() >= 2) {
			isCardDealt = true;
		}
		return isCardDealt;
	}

	
	public String toString() {
		StringBuilder str = new StringBuilder("card:");
		
		for (Card card : cards) {
			str.append(card.getCardRankEnum().getRank() + " " + card.getCardSuiteEnum().getSuite() + "\t");
		}
		return str.toString();
	}

}
