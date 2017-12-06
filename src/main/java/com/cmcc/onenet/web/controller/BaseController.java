package com.cmcc.onenet.web.controller;


import com.cmcc.onenet.constants.Errors;
import com.cmcc.onenet.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 基础controller
 * 
 * @author wannengjia@gmail.com
 */
@SuppressWarnings("rawtypes")
public class BaseController {
  public final Logger logger = LoggerFactory.getLogger(getClass());


  protected void throwException(int code, String codeLabel) {
    BusinessException e = new BusinessException(code, codeLabel, codeLabel);
    throw e;
  }

  protected void throwException(Errors error) {
    BusinessException e = new BusinessException(error, error.label);
    throw e;
  }

}
