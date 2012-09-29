package com.jko;

public class BadBoardException extends RuntimeException {

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
