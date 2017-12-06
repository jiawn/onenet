package com.cmcc.onenet.aop;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import com.cmcc.onenet.util.StringUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;

/**
 * 请求日志打印
 * 
 * @author wannengjia@gmail.com
 */
@Aspect
@Order(value = 1)
@Component
public class RequestAopLog {

  private Logger logger = LoggerFactory.getLogger(getClass());

  @Around("execution(* com.cmcc.onenet.*.controller..*.*(..))")
  public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
    RequestAttributes ra = RequestContextHolder.getRequestAttributes();
    if (ra != null) {
      ServletRequestAttributes sra = (ServletRequestAttributes) ra;
      HttpServletRequest request = sra.getRequest();
      requestLog(request);
      Object responseValue = getResponseLog(joinPoint);
      return responseValue;
    }
    return null;
  }

  /**
   * <pre>
   * 请求日志
   * </pre>
   * 
   * @param request
   */
  private void requestLog(HttpServletRequest request) {
    String newLine = getNewLine();
    StringBuilder content = new StringBuilder();
    content.append("[Request Header]: ").append(newLine);
    content.append("请求路径为").append(request.getServletPath()).append(newLine);
    content.append("请求头为");
    Enumeration<String> headNames = request.getHeaderNames();
    while (headNames.hasMoreElements()) {
      String name = headNames.nextElement();
      content.append(name).append("=").append(request.getHeader(name)).append("&");
    }
    content.append(newLine);
    content.append("请求参数为");
    String contentType = request.getContentType();
    if (contentType == null) {
      contentType = "";
    }
    if (contentType.indexOf("application/json") > -1
        || contentType.indexOf("json") > -1) {
      // FIXME : 此处是流的数据格式，暂时打印不出
    } else {
      Map<String, String[]> map = request.getParameterMap();
      if (map != null) {
        for (Entry<String, String[]> entry : map.entrySet()) {
          String value = reBuildRequestValue(entry.getValue());
          content.append(entry.getKey()).append("=").append(value).append("&");
        }
      }
      content.append(newLine);
    }

    logger.info(content.toString());
  }

  /**
   * <pre>
   * 重新构造请求的参数值
   * </pre>
   * 
   * @param value
   * @return
   */
  private String reBuildRequestValue(Object value) {
    if (value == null) {
      return "";
    }
    StringBuilder content = new StringBuilder();
    Object[] objs = null;
    if (value instanceof Object[]) {
      objs = (Object[]) value;
    } else if (value instanceof Collection) {
      Collection<?> coll = (Collection<?>) value;
      objs = coll.toArray();
    } else {
      objs = new Object[1];
      objs[0] = value;
    }
    if (objs != null) {
      int length = objs.length;
      for (int i = 0; i < length; i++) {
        content.append(objs[i]);
        if (i != length - 1) {
          content.append(",");
        }
      }
    }
    return content.toString();
  }

  /**
   * <pre>
   * 响应Log
   * </pre>
   * 
   * @param joinPoint
   * @throws Throwable
   */
  private Object getResponseLog(ProceedingJoinPoint joinPoint) throws Throwable {
    // 返回值
    Object result = joinPoint.proceed();
    String newLine = getNewLine();
    StringBuilder content = new StringBuilder();
    content.append("[Response Data]: ").append(newLine);
    if (result instanceof String) {
      content.append(result);
    } else {
      content.append(JSON.toJSONString(result));
    }
    logger.info(content.toString());
    return result;
  }

  /**
   * <pre>
   * 获取换行符
   * </pre>
   * 
   * @return
   */
  private String getNewLine() {
    return StringUtil.getNewLine();
  }

}
