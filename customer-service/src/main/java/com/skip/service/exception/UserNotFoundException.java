package com.skip.service.exception;

/**
 * RuntimeException for UserNotFound in database
 * @author Note-Chronos
 *
 */
public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "The user wasn't found in our system. Please try to sign-in.";
	}

}
