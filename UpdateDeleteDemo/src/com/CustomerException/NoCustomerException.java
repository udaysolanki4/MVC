package com.CustomerException;

@SuppressWarnings("serial")
public class NoCustomerException extends Exception {
	public NoCustomerException(String message) {
		super(message);
	}
	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
