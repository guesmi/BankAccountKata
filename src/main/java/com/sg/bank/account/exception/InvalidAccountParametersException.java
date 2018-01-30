package com.sg.bank.account.exception;

/**
 * @author guesmi
 * @version : 1.0
 *
 */
public class InvalidAccountParametersException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6937133323987513665L;

	public InvalidAccountParametersException(String message) {
		super(message);
	}

}
