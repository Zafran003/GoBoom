package com.mmu.goboom.player;

import com.mmu.goboom.Card;
import com.mmu.goboom.Player;

public class PlayerServiceImpl implements PlayerService{

    private boolean isWinner(Player player, Card highestCard) {
        if (player != null) {
            if (highestCard == null) {
                throw new NullPointerException("highestCard is null");
            }

            if (player.getPlayedCard() == null) {
                throw new NullPointerException("getPlayedCard is null");
            } else {

                if (player.getPlayedCard().equals("d")
                        && player.getPlayedCard().getValue().getCardValue() > highestCard.getValue().getCardValue()) {
                    return true;
                }

            }
        } else {
            throw new NullPointerException("player is null");
        }

        return false;
    }

    @Override
    public Player determineFirstPlayer(Card leadCard, Player player1, Player player2, Player player3,
            Player player4, int trickCount) {
        if (trickCount == 1) {
            switch (leadCard.getValue()) {
                case cA, c5, c9, cK, sA, s5, s9, sK, dA, d5, d9, dK, hA, h5, h9, hK:
                    return player1;
                case c2, c6, c10, s2, s6, s10, d2, d6, d10, h2, h6, h10:
                    return player2;
                case c3, c7, cJ, s3, s7, sJ, d3, d7, dJ, h3, h7, hJ:
                    return player3;
                case c4, c8, cQ, s4, s8, sQ, d4, d8, dQ, h4, h8, hQ:
                    return player4;
            }
        }

        // Use the original logic to determine the winner for subsequent tricks
        Player highestPlayer = player1;
        Card highestCard = player1.getPlayedCard();

        if (isWinner(player1, highestCard)) {
            highestPlayer = player1;
            highestCard = player1.getPlayedCard();
        }
        if (isWinner(player2, highestCard)) {
            highestPlayer = player2;
            highestCard = player2.getPlayedCard();
        }
        if (isWinner(player3, highestCard)) {
            highestPlayer = player3;
            highestCard = player3.getPlayedCard();
        }
        if (isWinner(player4, highestCard)) {
            highestPlayer = player4;
            highestCard = player4.getPlayedCard();
        }
        return highestPlayer;
    }

}
