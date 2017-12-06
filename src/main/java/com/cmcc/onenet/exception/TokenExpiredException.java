package com.cmcc.onenet.exception;


/**
 * 当token过期时使用该异常
 *
 * @author wannengjia@gmail.com
 */
public class TokenExpiredException extends AuthenticationException {

  private static final long serialVersionUID = 1L;

  public TokenExpiredException(String msg, Throwable t) {
    super(msg, t);
  }

  public TokenExpiredException(String msg) {
    super(msg);
  }

  public TokenExpiredException() {
    super();
  }

  public TokenExpiredException(Throwable cause) {
    super(cause);
  }

  protected TokenExpiredException(String message, Throwable cause, 
      boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

}
