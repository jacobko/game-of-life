package com.jko;

import static org.testng.Assert.assertEquals;

import java.io.ByteArrayInputStream;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestBoardReader {

	@DataProvider(name = "badBoards")
	public Object[][] badBoards() {
		return new Object[][] { { "" }, { "1 b 0" }, { "1 9 0" },
				{ "1 0\n0 0\n1 1 1" } };
	}

	@Test(dataProvider = "badBoards", expectedExceptions = BadBoardException.class)
	public void testBadBoard(String badBoard) throws Exception {
		System.setIn(new ByteArrayInputStream(badBoard.getBytes()));
		BoardReader.read();
	}

	@DataProvider(name = "goodBoards")
	public Object[][] goodBoards() {
		return new Object[][] {
				{ "1", new int[][] { { 1 } } },
				{ "1 1", new int[][] { { 1, 1 } } },
				{ "0\n0", new int[][] { { 0 }, { 0 } } },
				{ "0 1\n1 0", new int[][] { { 0, 1 }, { 1, 0 } } },
				{ "0 1 0\n1 1 1\n0 1 0",
						new int[][] { { 0, 1, 0 }, { 1, 1, 1 }, { 0, 1, 0 } } } };
	}

	@Test(dataProvider = "goodBoards")
	public void testGoodBoards(String goodBoard, int[][] expectedBoard)
			throws Exception {
		System.setIn(new ByteArrayInputStream(goodBoard.getBytes()));
		int[][] actualBoard = BoardReader.read();

		assertEquals(actualBoard, expectedBoard);
	}
}
