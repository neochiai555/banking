package com.ochiai.banking.core.exception;

public class ContaNaoEncontradaException extends Exception {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2973472763503330001L;

	public ContaNaoEncontradaException() {
		super();
	}
	
	public ContaNaoEncontradaException(String message, Throwable t) {
		super(message, t);
	}
	
	public ContaNaoEncontradaException(Throwable t) {
		super(t);
	}
	
	public ContaNaoEncontradaException(String message) {
		super(message);
	}
}
