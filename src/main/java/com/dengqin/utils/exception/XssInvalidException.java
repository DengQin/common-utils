package com.dengqin.utils.exception;

/**
 * XSS检测异常
 *
 * Created by dq on 2017/9/25.
 */
public class XssInvalidException extends SecurityException {

	private static final long serialVersionUID = 7016967341270813085L;

	public XssInvalidException() {
		super();
	}

	public XssInvalidException(String message, Throwable cause) {
		super(message, cause);
	}

	public XssInvalidException(String s) {
		super(s);
	}

	public XssInvalidException(Throwable cause) {
		super(cause);
	}
}
