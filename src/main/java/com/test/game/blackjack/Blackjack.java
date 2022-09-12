package com.test.game.blackjack;

import java.util.List;
import java.util.Scanner;

import com.test.game.blackjack.card.deck.DeckOfCard;
import com.test.game.blackjack.card.deck.constants.DecisionEnum;
import com.test.game.blackjack.dealer.Dealer;
import com.test.game.blackjack.player.Player;

public class Blackjack {
	
	private DeckOfCard deck;
	private List<Player> players;
	private Dealer dealer;
	
	public Blackjack(DeckOfCard deck, List<Player> players, Dealer dealer) {
		this.deck = deck;
		this.players = players;
		this.dealer = dealer;
	}
	
	public void play() {
		shuffle();
		serveFirstRoundCards();
		serveSecodRoundCards();
		printResult();
	}
	
	private void shuffle() {
		deck.shuffle();
	}
	
	private void serveFirstRoundCards() {
		System.out.println("Dealer: serving first round of card to all");
		
		for (Player player : players) {
			player.insert(deck.drawCard());
			System.out.println("Dealing to " + player.getName() + " " + player.toString());
		}
		dealer.insert(deck.drawCard());
		System.out.println("Dealing to computer, card: face down");
	}
	
	private void serveSecodRoundCards() {
		System.out.println("Dealer: serving second round of card to all");
		
		Scanner scanner = new Scanner(System.in);
		for (Player player : players) {
			player.insert(deck.drawCard());
			System.out.print("Dealing to " + player.getName() + " " + player.toString() + " " +  DecisionEnum.HIT.getDecison() + " or " + DecisionEnum.STAND.getDecison() + "?");
			String hitOrStand = scanner.next();
			
			while (hitOrStand.equalsIgnoreCase(DecisionEnum.HIT.getDecison())) {
				
				player.insert(deck.drawCard());
				System.out.print("Dealing to " + player.getName() + " " + player.toString());
				
				if (player.value() < 22) {
					System.out.print(DecisionEnum.HIT.getDecison() + " or " + DecisionEnum.STAND.getDecison() + "?");
					hitOrStand = scanner.next();
				}
				else {
					hitOrStand = "";
					System.out.println(" ** Busted over 21. **");
				}
			}
		}
		scanner.close();
		
		
		dealer.insert(deck.drawCard());
		System.out.print("Dealing to computer "  + dealer.toString());
		
		boolean isBusted = false;
		while (dealer.shouldHit()) {
			System.out.println(" Dealer Hits ");
			
			dealer.insert(deck.drawCard());
			System.out.print("Dealing to computer "  + dealer.toString());
			if (dealer.value() > 21) {
				System.out.println("** Dealer Busted ** ");
				isBusted = true;
			}
		}
		if (!isBusted)
			System.out.println(" Dealer Stand ");
	}
	
	private void printResult() {
		System.out.println();
		if (dealer.value() > 21) {
			System.out.println("Dealer Busted So all non-busted players won again dealer");
		}
		else {
			for (Player player : players) {
				if (player.value() > 21 ) {
					System.out.println("Scoring: " + player.getName() + " busted. Dealer Won");
				}
				else {
					System.out.print("Scoring: " + player.getName() + " has " + player.value() + " dealer has " + dealer.value() + "\t");
					if (dealer.value() >= player.value()) {
						System.out.println("Dealer won against " + player.getName());
					}
					else {
						System.out.println(player.getName() + " won against dealer");
					}
				}
			}
		}
	}
}
