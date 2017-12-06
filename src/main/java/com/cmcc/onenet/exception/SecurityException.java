//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cmcc.onenet.exception;

/**
 * @author wannengjia@gmail.com
 */
public class SecurityException extends CommonException {
	private static final long serialVersionUID = 1L;

	public SecurityException(String msg, Throwable t) {
		super(msg, t);
	}

	public SecurityException(String msg) {
		super(msg);
	}

	public SecurityException() {
	}

	public SecurityException(Throwable cause) {
		super(cause);
	}

	protected SecurityException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
