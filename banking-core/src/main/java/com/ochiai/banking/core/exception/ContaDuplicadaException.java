package com.ochiai.banking.core.exception;

public class ContaDuplicadaException extends Exception {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -176099602159131868L;

	public ContaDuplicadaException() {
		super();
	}
	
	public ContaDuplicadaException(String message, Throwable t) {
		super(message, t);
	}
	
	public ContaDuplicadaException(Throwable t) {
		super(t);
	}
	
	public ContaDuplicadaException(String message) {
		super(message);
	}
}
