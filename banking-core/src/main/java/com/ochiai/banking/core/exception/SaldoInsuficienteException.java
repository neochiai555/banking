package com.ochiai.banking.core.exception;

public class SaldoInsuficienteException extends Exception {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3028906626041967829L;

	public SaldoInsuficienteException() {
		super();
	}
	
	public SaldoInsuficienteException(String message, Throwable t) {
		super(message, t);
	}
	
	public SaldoInsuficienteException(Throwable t) {
		super(t);
	}
	
	public SaldoInsuficienteException(String message) {
		super(message);
	}
}
