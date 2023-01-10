package com.zensar.cms.exception;

public class CMSException extends Exception {

	private static final long serialVersionUID = 3537142457510790215L;

	public CMSException() {
		super();
	}

	public CMSException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CMSException(String message, Throwable cause) {
		super(message, cause);
	}

	public CMSException(String message) {
		super(message);
	}

	public CMSException(Throwable cause) {
		super(cause);
	}
}
