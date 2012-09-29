package com.jko;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestEvolve {

	@DataProvider(name = "cellsAlive")
	public Object[][] cellsAliveData() {
		return new Object[][] { { new int[][] { { 0 } }, 0 },
				{ new int[][] { { 1 } }, 1 }, { new int[][] { { 0, 1 } }, 1 },
				{ new int[][] { { 0 }, { 1 } }, 1 },
				{ new int[][] { { 0, 1, 0 }, { 1, 1, 1 }, { 0, 1, 0 } }, 5 } };
	}

	@Test(dataProvider = "cellsAlive")
	public void cellsAlive(int[][] board, int alive) {
		assertEquals(Evolve.cellsAlive(board), alive);
	}

	@DataProvider(name = "nextBoard")
	public Object[][] nextBoardData() {
		return new Object[][] {
				{ new int[][] { { 0 } }, new int[][] { { 0 } } },
				{ new int[][] { { 1 } }, new int[][] { { 0 } } },
				{ new int[][] { { 0, 1 } }, new int[][] { { 0, 0 } } },
				{ new int[][] { { 0 }, { 1 } }, new int[][] { { 0 }, { 0 } } },
				{ new int[][] { { 1, 1, 1 } }, new int[][] { { 0, 1, 0 } } },
				{ new int[][] { { 1 }, { 1 }, { 1 } },
						new int[][] { { 0 }, { 1 }, { 0 } } },
				{ new int[][] { { 0, 1, 0 }, { 1, 1, 1 }, { 0, 1, 0 } },
						new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } } } };
	}

	@Test(dataProvider = "nextBoard")
	public void nextBoard(int[][] board, int[][] nextBoard) {
		assertEquals(Evolve.nextBoard(board), nextBoard);
	}

}
