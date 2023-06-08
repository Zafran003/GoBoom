package com.mmu.goboom.player;

import com.mmu.goboom.Player;

public class PlayerUtil {

    // Helper method to get the next player in a clockwise rotation
    public static Player getNextPlayer(Player currentPlayer, Player player1, Player player2, Player player3,
            Player player4) {
        if (currentPlayer == player1) {
            return player2;
        } else if (currentPlayer == player2) {
            return player3;
        } else if (currentPlayer == player3) {
            return player4;
        } else {
            return player1;
        }
    }
}
