package com.test.game.blackjack.dealer.strategy.basic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.test.game.blackjack.card.deck.Card;
import com.test.game.blackjack.card.deck.constants.CardRankEnum;
import com.test.game.blackjack.card.deck.constants.CardSuiteEnum;
import com.test.game.blackjack.card.deck.constants.DecisionEnum;
import com.test.game.blackjack.dealer.strategy.Strategy;
import com.test.game.blackjack.player.Player;

public class StrategySixteenTest {


	
	@Test
	public void apply_stand_winning() {
		List<Player> players = players();
		Strategy strategy = new StrategySixteen(players);		
		assertEquals(DecisionEnum.STAND, strategy.apply(20));
	}
	
	@Test
	public void apply_stand_17() {
		List<Player> players = players();
		Strategy strategy = new StrategySixteen(players);		
		assertEquals(DecisionEnum.STAND, strategy.apply(18));
	}
	
	@Test
	public void apply_hit() {
		List<Player> players = players();
		Strategy strategy = new StrategySixteen(players);		
		assertEquals(DecisionEnum.HIT, strategy.apply(15));
	}
	
	private List<Player> players() {
		List<Player> players = new ArrayList<>();
		
		Card card = new Card(CardSuiteEnum.CLUBS, CardRankEnum.ACE);
		Player player = new Player();
		player.insert(card);
		card = new Card(CardSuiteEnum.CLUBS, CardRankEnum.EIGHT);
		player.insert(card);
		players.add(player);
		
		player = new Player();
		card = new Card(CardSuiteEnum.SPADES, CardRankEnum.FIVE);
		player.insert(card);	
		card = new Card(CardSuiteEnum.CLUBS, CardRankEnum.NINE);
		player.insert(card);
		players.add(player);
		
		return players;
		
	}
}
