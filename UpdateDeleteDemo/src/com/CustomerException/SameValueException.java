package com.CustomerException;

@SuppressWarnings("serial")
public class SameValueException extends Exception {
public SameValueException(String message) {
	super(message);
}
@Override
public String getMessage() {
	return super.getMessage();
}
}
