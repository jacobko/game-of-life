package com.jko;

public class GameOfLife {

	public static void main(String[] args) throws Exception {
		int[][] board = BoardReader.read();

		System.out.println("Generation 0:");
		printBoard(board);

		int count = 1;
		while (Evolve.cellsAlive(board) > 0) {
			board = Evolve.nextBoard(board);

			System.out.println("Generation " + count + ":");
			printBoard(board);
			count++;
		}
	}

	public static void printBoard(int[][] board) {
		for (int[] row : board) {
			for (int place : row) {
				System.out.print(place + " ");
			}
			System.out.println("");
		}

		System.out.println("");
	}

}
