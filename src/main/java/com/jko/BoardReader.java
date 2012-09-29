package com.jko;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Read a board for Conway's Game of Life from stdin. Check to see if the board
 * is valid.
 * 
 */
public class BoardReader {

	private BoardReader() {
		throw new AssertionError("This class cannot be instantiated.");
	}

	/**
	 * Read the board from stdin and check the validity.
	 * 
	 * @return A two-dimensional integer array representation of the board.
	 * @throws IOException
	 *             If an I/O error occurs.
	 */
	public static int[][] read() throws IOException {
		List<int[]> board = new ArrayList<int[]>();

		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(System.in));

		String line;
		while ((line = bufferedReader.readLine()) != null) {
			String[] places = line.split(" ");

			int[] row = new int[places.length];
			for (int i = 0; i < places.length; i++) {
				try {
					row[i] = Integer.parseInt(places[i]);
				} catch (NumberFormatException nfe) {
					throw new BadBoardException(nfe);
				}

				if (!(row[i] == 0 || row[i] == 1)) {
					throw new BadBoardException(
							"Values on the board can only be 0 or 1.");
				}
			}
			board.add(row);
		}

		if (board.size() == 0) {
			throw new BadBoardException("The board must be at least 1x1.");
		} else {
			int rowLength = board.get(0).length;
			for (int[] row : board) {
				if (row.length != rowLength) {
					throw new BadBoardException(
							"The board must be rectangular.");
				}
			}
		}

		return board.toArray(new int[board.size()][board.get(0).length]);
	}
}
