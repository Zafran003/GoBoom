package com.mmu.goboom;

import java.util.ArrayList;

public class Player { // player class where we can create the instances of players
	private String playerName;
	private ArrayList<Card> handOfPlayer;
	private Card playedCard;

	public Player() {
	}

	public Player(String playerName) {
		this.playerName = playerName; ///
		this.handOfPlayer = new ArrayList<>(); /// //this will initialize players hand variable with an empty array
	} /// the players hand is now an array that is empty

	public void addCard(Card card) {
		handOfPlayer.add(card); /// this will add cards into the players hand array
	}

	// Other methods for the Player class

	@Override
	public String toString() {
		return playerName + ": " + handOfPlayer; // the toString method
	}

	public boolean hasCards() {
		return !handOfPlayer.isEmpty();
	}

	public String getPlayerName() {
		return playerName;
	}

	public String drawCard(ArrayList<Card> centerArray, Deck deck) {
		if (deck.getDeck().size() > 0) {
			Card card = deck.getDeck().get(0);
			deck.removeCard(0);
			handOfPlayer.add(card);
			return "success";
		} else {
			return "error";
		}
	}

	public boolean playCard(String userInput, ArrayList<Card> centerArray) {
		if (!handOfPlayer.isEmpty()) {
			for (int i = 0; i < handOfPlayer.size(); i++) {
				Card card = handOfPlayer.get(i);
				if (card.toString().equals(userInput)) {
					handOfPlayer.remove(i);
					playedCard = card;
					centerArray.add(card);
					return true;
				}
			}
		}
		return false;
	}

	public Card getPlayedCard() {
		return playedCard;
	}

	public ArrayList<Card> getHandOfPlayer() {
		return handOfPlayer;
	}

	public void setHandOfPlayer(ArrayList<Card> handOfPlayer) {
		this.handOfPlayer = handOfPlayer;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public void setPlayedCard(Card playedCard) {
		this.playedCard = playedCard;
	}

}