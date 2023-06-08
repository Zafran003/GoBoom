package com.mmu.goboom;

import java.util.ArrayList;

public class GameMemory {

	private Card leadCard;
	private Deck deck = new Deck();
	private Player player1;
	private Player player2;
	private Player player3;
	private Player player4;
	private int trickCount;
	private ArrayList<Card> centerArray = new ArrayList<>();

	public ArrayList<Card> getCenterArray() {
		return centerArray;
	}

	public void setCenterArray(ArrayList<Card> centerArray) {
		this.centerArray = centerArray;
	}

	public Card getLeadCard() {
		return leadCard;
	}

	public void setLeadCard(Card leadCard) {
		this.leadCard = leadCard;
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public Player getPlayer3() {
		return player3;
	}

	public void setPlayer3(Player player3) {
		this.player3 = player3;
	}

	public Player getPlayer4() {
		return player4;
	}

	public void setPlayer4(Player player4) {
		this.player4 = player4;
	}

	public int getTrickCount() {
		return trickCount;
	}

	public void setTrickCount(int trickCount) {
		this.trickCount = trickCount;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

}
