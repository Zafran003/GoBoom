package com.mmu.goboom;

import com.mmu.goboom.init.*;
import com.mmu.goboom.executor.*;

public class MainGame {
	public static void main(String[] args) {

		InitService InitService = new InitServiceImpl();
		GameMemory memory = InitService.init();

		ExecutorService executorService = new ExecutorServiceImpl();
		executorService.run(memory.getLeadCard(), memory.getPlayer1(), memory.getPlayer2(), memory.getPlayer3(),
				memory.getPlayer4(), memory.getTrickCount(), memory.getDeck(), memory.getCenterArray());

	}

}
