//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.cmcc.onenet.exception;

import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;

/**
 * @author wannengjia@gmail.com
 * @param <T>
 */
public class ErrorResponseEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	private T message;
	private long timestamp;
	private String exception;
	private int bizCode;
	private int httpStatus;
	private String path;

	public ErrorResponseEntity() {
	}

	public T getMessage() {
		return this.message;
	}

	public void setMessage(T message) {
		this.message = message;
	}

	public long getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getException() {
		return this.exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public int getBizCode() {
		return this.bizCode;
	}

	public void setBizCode(int bizCode) {
		this.bizCode = bizCode;
	}

	public int getHttpStatus() {
		return this.httpStatus;
	}

	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public static <T> ErrorResponseEntity<T> fail(Integer httpStatus, Integer bizCode, HttpServletRequest request) {
		return fail(httpStatus, bizCode,null, null, request);
	}

	public static <T> ErrorResponseEntity<T> fail(Integer httpStatus, Integer bizCode, T message, HttpServletRequest request) {
		return fail(httpStatus, bizCode, (Exception)null, message, request);
	}

	public static <T> ErrorResponseEntity<T> fail(Integer httpStatus, Integer bizCode, Exception exception, HttpServletRequest request) {
		return fail(httpStatus, bizCode, exception, null, request);
	}

	public static <T> ErrorResponseEntity<T> fail(Integer httpStatus, Integer bizCode, Exception exception, T message, HttpServletRequest request) {
		ErrorResponseEntity<T> errorResponse = new ErrorResponseEntity();
		errorResponse.message = message;
		if (null != exception) {
			errorResponse.exception = exception.getClass().getCanonicalName();
		}

		if (null != request) {
			errorResponse.path = request.getRequestURI();
		}

		errorResponse.httpStatus = httpStatus.intValue();
		errorResponse.bizCode = bizCode.intValue();
		errorResponse.timestamp = System.currentTimeMillis();
		return errorResponse;
	}
}
