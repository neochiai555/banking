package com.ochiai.banking.conteudo.exception;

public class ConteudoException extends Exception {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1026581129896048158L;

	public ConteudoException() {
		super();
	}
	
	public ConteudoException(String message, Throwable ex) {
		super(message, ex);
	}

	public ConteudoException(String message) {
		super(message);
	}

	public ConteudoException(Throwable ex) {
		super(ex);
	}
}
