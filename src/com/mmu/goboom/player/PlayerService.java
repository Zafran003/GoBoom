package com.mmu.goboom.player;

import com.mmu.goboom.Card;
import com.mmu.goboom.Player;

public interface PlayerService {

	Player determineFirstPlayer(Card leadCard, Player player1, Player player2, Player player3, Player player4,
			int trickCount);

}
