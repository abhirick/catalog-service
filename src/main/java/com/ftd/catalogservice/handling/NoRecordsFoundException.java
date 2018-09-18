package com.ftd.catalogservice.handling;

/**
 * <p>
 * This is a custom exception that is thrown when particular resource is not
 * found in Cassandra DB.
 * </p>
 * 
 * @author Abhishek Mallick
 *
 */
public class NoRecordsFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	private int code;

	private String message;

	public NoRecordsFoundException(String msg) {
		message = msg;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
