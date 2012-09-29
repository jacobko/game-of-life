package com.jko;

public class Generation {

	private Generation() {
		throw new AssertionError("This class cannot be instantiated.");
	}

	public static int next(int[][] board, int x, int y) {
		if (x >= board.length || y >= board[0].length)
			throw new IndexOutOfBoundsException();

		return nextGeneration(board[x][y], neighbors(board, x, y));
	}

	public static int neighbors(int[][] board, final int x, final int y) {
		int neighbors = 0;

		for (int i = x - 1; i <= x + 1; i++) {
			if (i >= 0 && i < board.length) {
				for (int j = y - 1; j <= y + 1; j++) {
					if (j >= 0 && j < board[0].length) {
						if (!(i == x && j == y)) {
							neighbors += board[i][j];
						}
					}
				}
			}
		}

		return neighbors;
	}

	public static int nextGeneration(int current, int neighbors) {
		int result = 0;

		if ((current == 0 && neighbors == 3)
				|| (current == 1 && (neighbors == 2 || neighbors == 3))) {
			result = 1;
		}

		return result;
	}

}
