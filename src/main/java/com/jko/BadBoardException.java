package com.jko;

/**
 * Thrown to indicate that the board is not a valid board for Conway's Game of
 * Life.
 * 
 */
public class BadBoardException extends RuntimeException {

	private static final long serialVersionUID = -859607005819609912L;

	public BadBoardException() {
		super();
	}

	public BadBoardException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public BadBoardException(String arg0) {
		super(arg0);
	}

	public BadBoardException(Throwable arg0) {
		super(arg0);
	}

}
