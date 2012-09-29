package com.jko;

public class Evolve {

	private Evolve() {
		throw new AssertionError("This class cannot be instantiated.");
	}

	public static int cellsAlive(int[][] board) {
		int result = 0;

		for (int[] row : board) {
			for (int place : row) {
				result += place;
			}
		}

		return result;
	}

	public static int[][] nextBoard(int[][] board) {
		int[][] nextBoard = new int[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				nextBoard[i][j] = Generation.next(board, i, j);
			}
		}

		return nextBoard;
	}

}
