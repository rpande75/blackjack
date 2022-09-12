package com.test.game.blackjack.dealer;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.test.game.blackjack.card.deck.Card;
import com.test.game.blackjack.card.deck.constants.CardRankEnum;
import com.test.game.blackjack.card.deck.constants.CardSuiteEnum;
import com.test.game.blackjack.card.deck.constants.DecisionEnum;
import com.test.game.blackjack.dealer.strategy.basic.StrategySixteen;

public class DealerTest {

	@Test
	public void shouldHit_false() {
		
		StrategySixteen strategy = mock(StrategySixteen.class);
		Dealer dealer = new Dealer("Dealer", strategy);
		Card card = new Card(CardSuiteEnum.CLUBS, CardRankEnum.ACE);
		dealer.insert(card);
		card = new Card(CardSuiteEnum.CLUBS, CardRankEnum.EIGHT);
		dealer.insert(card);
		when(strategy.apply(17)).thenReturn(DecisionEnum.STAND);
		assertFalse(dealer.shouldHit());
		
	}
	
	@Test
	public void shouldHit_true() {
		
		StrategySixteen strategy = mock(StrategySixteen.class);
		Dealer dealer = new Dealer("Dealer", strategy);
		Card card = new Card(CardSuiteEnum.CLUBS, CardRankEnum.TWO);
		dealer.insert(card);
		card = new Card(CardSuiteEnum.CLUBS, CardRankEnum.EIGHT);
		dealer.insert(card);
		when(strategy.apply(10)).thenReturn(DecisionEnum.HIT);
		assertTrue(dealer.shouldHit());
	}
}
