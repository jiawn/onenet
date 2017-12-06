package com.cmcc.onenet.web.controller;

import com.cmcc.onenet.constants.Errors;
import com.cmcc.onenet.exception.BusinessException;
import com.cmcc.onenet.exception.CommonException;
import com.cmcc.onenet.exception.ErrorResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartException;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

/**
 * <pre>
 * 异常响应处理。将异常包装为固定的格式并返回。
 * 指定格式为{@link }。
 * </pre>
 * 
 * @author wannengjia@gmail.com
 */
@ControllerAdvice
public class ControllerAssist {

  private Logger logger = LoggerFactory.getLogger(getClass());

  /**
   * 注册全局数据编辑器，若传递的数据为空字串 转成 null
   * 
   * @param binder
   *          数据绑定
   * @param request
   *          web请求
   */
  @InitBinder
  public void registerCustomEditors(WebDataBinder binder, WebRequest request) {
    binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
  }

  /**
   * 处理业务异常
   * 
   * @param exception
   * @param request
   * @return
   */
  @ExceptionHandler(BusinessException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  @ResponseBody
  public ErrorResponseEntity<?> handleBusinessException(BusinessException exception, HttpServletRequest request) {
    logger.info("", exception);
    return ErrorResponseEntity.fail(HttpStatus.BAD_REQUEST.value(), exception.getCode(), exception,
        exception.getLabel(), request);
  }

  /**
   * 处理请求参数验证异常
   * 
   * @param exception
   * @param request
   * @return
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  @ResponseBody
  public ErrorResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception,
      HttpServletRequest request) {
    logger.info("", exception);
    Errors error = Errors.SYSTEM_REQUEST_PARAM_ERROR;
    String message = error.label;
    BindingResult bindingResult = exception.getBindingResult();
    if (bindingResult != null && bindingResult.hasErrors()) {
      List<ObjectError> objectErrorList = bindingResult.getAllErrors();
      if (!objectErrorList.isEmpty()) {
        message = objectErrorList.get(0).getDefaultMessage();
      }
    }
    return ErrorResponseEntity.fail(HttpStatus.BAD_REQUEST.value(), error.code, exception, message, request);
  }

  /**
   * 处理服务器端数据访问错误
   *
   * @param request
   *          请求对象
   * @param exception
   *          异常对象
   * @param locale
   *          地理信息
   * @return
   */
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler({ SQLException.class, DataAccessException.class, DataAccessResourceFailureException.class,
      org.mybatis.spring.MyBatisSystemException.class, CommonException.class, DataIntegrityViolationException.class })
  @ResponseBody
  public ErrorResponseEntity<?> handleSQLException(HttpServletRequest request, Exception exception, Locale locale) {
    logger.info("", exception);
    Errors error = Errors.SYSTEM_ERROR;
    return ErrorResponseEntity.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), error.code, exception, error.label, request);
  }
//  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
//  @ExceptionHandler(CommonException.class)
//  @ResponseBody
//  public ErrorResponseEntity<?> handleDubboeException(HttpServletRequest request, Exception exception, Locale locale) {
//    logger.info("", exception);
//    Errors error = Errors.SYSTEM_ERROR;
//    return ErrorResponseEntity.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), error.code, exception,
//        error.label, request);
//  }

  /**
   * 处理服务器端RuntimeException
   * 
   * @param request
   *          请求对象
   * @param exception
   *          异常对象
   * @param locale
   *          地理信息
   * @return
   */
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler({ RuntimeException.class })
  @ResponseBody
  public ErrorResponseEntity<?> handleAllException(HttpServletRequest request, Exception exception, Locale locale) {
    logger.info("", exception);
    Errors error = Errors.SYSTEM_ERROR;
    return ErrorResponseEntity.fail(HttpStatus.INTERNAL_SERVER_ERROR.value(), error.code, exception,
        error.label, request);
  }

}
