package com.test.game.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.test.game.blackjack.card.deck.DeckOfCard;
import com.test.game.blackjack.dealer.Dealer;
import com.test.game.blackjack.dealer.strategy.Strategy;
import com.test.game.blackjack.dealer.strategy.basic.StrategySixteen;
import com.test.game.blackjack.player.Player;

public class BlackjackTest {

	public static void main(String[] args) {
		
		DeckOfCard deck = new DeckOfCard();		
		List<Player> players = new ArrayList<>();
		players.add(new Player("Sean"));
		players.add(new Player("Kevin"));
		players.add(new Player("Charlie"));
		
		Strategy strategy = new StrategySixteen(players);
		Dealer dealer = new Dealer("Jack", strategy);
		
		System.out.println("Hello, Welcome to blackjack!! I'm your dealer today and my name is " + dealer.getName());
		System.out.println("Today we are going to play balckjack with Sean, Kevin and Charlie sitting in clockwise direction");
		
		
		Blackjack blackjack = new Blackjack(deck, players, dealer);
		blackjack.play();
	}

}
