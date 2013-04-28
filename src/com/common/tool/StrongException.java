package com.common.tool;

public class StrongException extends RuntimeException {

	private static final long serialVersionUID = -3004202739188242099L;

	public StrongException(String frdMessage) {
		super(frdMessage);
	}

	public StrongException(Throwable throwable) {
		super(throwable);
	}

	public StrongException(Throwable throwable, String frdMessage) {
		super(throwable);
	}
}
