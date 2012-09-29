package com.jko;

/**
 * Utilites for determining how a cell will evolve in the next generation in
 * Conway's Game of Life.
 * 
 */
public class Generation {

	private Generation() {
		throw new AssertionError("This class cannot be instantiated.");
	}

	/**
	 * Finds the value of the cell in the next generation.
	 * 
	 * @param board
	 *            A board for Conway's Game of Life.
	 * @param x
	 *            The x-index of the cell in question.
	 * @param y
	 *            The y-index of the cell in question.
	 * @return The next value of the cell.
	 */
	public static int next(int[][] board, int x, int y) {
		if (x >= board.length || y >= board[0].length)
			throw new IndexOutOfBoundsException();

		return nextGeneration(board[x][y], neighbors(board, x, y));
	}

	/**
	 * Counts the neighbors of a cell.
	 * 
	 * @param board
	 *            A board for Conway's Game of Life.
	 * @param x
	 *            The x-index of the cell in question.
	 * @param y
	 *            The y-index of the cell in question.
	 * @return The number of neighbors of that cell.
	 */
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

	/**
	 * Returns the status of a cell in the next generation based on its current
	 * state and the number of neighbors it has.
	 * 
	 * @param current
	 *            The current value of the cell.
	 * @param neighbors
	 *            The number of neighbors the cell has.
	 * @return The value of the cell in the next generation.
	 */
	public static int nextGeneration(int current, int neighbors) {
		int result = 0;

		if ((current == 0 && neighbors == 3)
				|| (current == 1 && (neighbors == 2 || neighbors == 3))) {
			result = 1;
		}

		return result;
	}

}
