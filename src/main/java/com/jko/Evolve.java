package com.jko;

/**
 * Utilities for generating the next generation of a board in Conway's Game of
 * Life.
 * 
 */
public class Evolve {

	private Evolve() {
		throw new AssertionError("This class cannot be instantiated.");
	}

	/**
	 * Counts the number of "alive" cells on the board.
	 * 
	 * @param board
	 *            A board for Conway's Game of Life.
	 * @return the number of "alive" cells.
	 */
	public static int cellsAlive(int[][] board) {
		int result = 0;

		for (int[] row : board) {
			for (int place : row) {
				result += place;
			}
		}

		return result;
	}

	/**
	 * Creates the next generation of the board in Conway's Game of Life.
	 * 
	 * @param board
	 *            A board for Conway's Game of Life.
	 * @return The board after one generation.
	 */
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
