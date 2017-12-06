package com.cmcc.onenet.exception;


/**
 * 当token无效时，使用该异常
 *
 * @author wannengjia@gmail.com
 */
public class InvalidTokenException extends AuthenticationException {

  private static final long serialVersionUID = 1L;

  /**
   * 构造函数
   * @param msg 异常欣喜
   * @param t   源异常
   */
  public InvalidTokenException(String msg, Throwable t) {
    super(msg, t);
  }

  /**
   * 构造函数
   * @param msg 异常欣喜
   */
  public InvalidTokenException(String msg) {
    super(msg);
  }

  /**
   * 构造函数
   */
  public InvalidTokenException() {
    super();
  }

  /**
   * 构造函数
   * @param cause   源异常
   */
  public InvalidTokenException(Throwable cause) {
    super(cause);
  }

  /**
   * 构造函数
   * @param message             异常欣喜
   * @param cause               源异常
   * @param enableSuppression   是否抑制异常
   * @param writableStackTrace  是否可以写调用栈
   */
  protected InvalidTokenException(String message, Throwable cause, 
      boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

}
