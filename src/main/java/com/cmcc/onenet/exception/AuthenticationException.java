//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cmcc.onenet.exception;

/**
 * @author wannengjia@gmail.com
 */
public class AuthenticationException extends SecurityException {
	private static final long serialVersionUID = 1L;

	public AuthenticationException(String msg, Throwable t) {
		super(msg, t);
	}

	public AuthenticationException(String msg) {
		super(msg);
	}

	public AuthenticationException() {
	}

	public AuthenticationException(Throwable cause) {
		super(cause);
	}

	protected AuthenticationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
