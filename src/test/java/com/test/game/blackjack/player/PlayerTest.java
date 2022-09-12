package com.test.game.blackjack.player;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.test.game.blackjack.card.deck.Card;
import com.test.game.blackjack.card.deck.constants.CardRankEnum;
import com.test.game.blackjack.card.deck.constants.CardSuiteEnum;

public class PlayerTest {
	
	@Test
	public void value_ace_11() {
		Card card = new Card(CardSuiteEnum.CLUBS, CardRankEnum.ACE);
		Player player = new Player();
		player.insert(card);
		assertEquals(11, player.value());
	}
	
	@Test
	public void value_ace_1() {
		Card card = new Card(CardSuiteEnum.CLUBS, CardRankEnum.KING);
		Card cardAce = new Card(CardSuiteEnum.CLUBS, CardRankEnum.ACE);
		Card cardThree = new Card(CardSuiteEnum.CLUBS, CardRankEnum.THREE);
		Player player = new Player();
		player.insert(card);
		player.insert(cardAce);
		player.insert(cardThree);
		assertEquals(14, player.value());
	}
	
	@Test
	public void value_3() {
		Card card = new Card(CardSuiteEnum.CLUBS, CardRankEnum.THREE);
		Player player = new Player();
		player.insert(card);
		assertEquals(3, player.value());
	}

	@Test
	public void value_jack_10() {
		Card card = new Card(CardSuiteEnum.CLUBS, CardRankEnum.JACK);
		Player player = new Player();
		player.insert(card);
		assertEquals(10, player.value());
	}
	
	@Test
	public void value_queen_10() {
		Card card = new Card(CardSuiteEnum.CLUBS, CardRankEnum.QUEEN);
		Player player = new Player();
		player.insert(card);
		assertEquals(10, player.value());
	}
	
	@Test
	public void value_king_10() {
		Card card = new Card(CardSuiteEnum.CLUBS, CardRankEnum.KING);
		Player player = new Player();
		player.insert(card);
		assertEquals(10, player.value());
	}
	
}
