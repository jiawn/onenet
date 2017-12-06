package com.cmcc.onenet.service.impl;

import com.cmcc.onenet.constants.Errors;
import com.cmcc.onenet.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wannengjia@gmail.com
 * @Description:
 * @Date: Create in 2017/12/7 0:23
 */
public abstract class BaseService {
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
