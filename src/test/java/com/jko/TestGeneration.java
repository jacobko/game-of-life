package com.jko;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestGeneration {

	@DataProvider(name = "neighbors")
	public Object[][] neighborsData() {
		List<Object[]> neighbors = new ArrayList<Object[]>();

		for (int a = 0; a < 2; a++) {
			for (int b = 0; b < 2; b++) {
				for (int c = 0; c < 2; c++) {
					for (int d = 0; d < 2; d++) {
						for (int e = 0; e < 2; e++) {
							for (int f = 0; f < 2; f++) {
								for (int g = 0; g < 2; g++) {
									for (int h = 0; h < 2; h++) {
										for (int i = 0; i < 2; i++) {
											neighbors.add(new Object[] {
													new int[][] { { a, b, c },
															{ d, e, f },
															{ g, h, i } },
													b + d + e,
													a + c + d + e + f,
													a + b + c + d + f + g + h
															+ i,
													b + c + e + h + i,
													e + f + h });
										}
									}
								}
							}
						}
					}
				}
			}
		}

		return neighbors.toArray(new Object[][] {});
	}

	@Test(dataProvider = "neighbors")
	public void neighbors(int[][] board, int expectedTopLeft,
			int expectedTopCenter, int expectedMiddleCenter,
			int expectedMiddleRight, int expectedBottomRight) {
		assertEquals(Generation.neighbors(board, 0, 0), expectedTopLeft,
				"top left does not match");

		assertEquals(Generation.neighbors(board, 0, 1), expectedTopCenter,
				"top center does not match");

		assertEquals(Generation.neighbors(board, 1, 1), expectedMiddleCenter,
				"middle center does not match");

		assertEquals(Generation.neighbors(board, 1, 2), expectedMiddleRight,
				"middle right does not match");

		assertEquals(Generation.neighbors(board, 2, 2), expectedBottomRight,
				"bottom right does not match");
	}

	@DataProvider(name = "generation")
	public Object[][] generationData() {
		return new Object[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 2, 0 },
				{ 0, 3, 1 }, { 0, 4, 0 }, { 0, 5, 0 }, { 0, 6, 0 },
				{ 0, 7, 0 }, { 0, 8, 0 }, { 1, 0, 0 }, { 1, 1, 0 },
				{ 1, 2, 1 }, { 1, 3, 1 }, { 1, 4, 0 }, { 1, 5, 0 },
				{ 1, 6, 0 }, { 1, 7, 0 }, { 1, 8, 0 } };
	}

	@Test(dataProvider = "generation")
	public void generation(int current, int neighbors, int expectedNext) {
		assertEquals(Generation.nextGeneration(current, neighbors),
				expectedNext);
	}

}
