package com.cmcc.onenet.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


/**
 * 权限控制拦截器.
 * 
 * @author wannengjia@gmail.com
 */
@Component
public class AccessControlInterceptor extends HandlerInterceptorAdapter {

  // private Logger logger = LoggerFactory.getLogger(getClass());

  private static final List<String> noLoginResources = new ArrayList<String>() {
    private static final long serialVersionUID = 1L;

    {
      // swagger相关资源不需要登录
      add("/swagger-ui.html");
      add("/configuration");
      add("/swagger-resources");
      add("/api-docs");
      add("/v2/api-docs");

      add("/login");
      add("/loginCode");
      add("/logout");

    }
  };

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

    // 不需要进行访问控制的资源过滤
    String uri = request.getRequestURI();
    boolean needLogin = true;
    if ("/".equals(uri)) {
      needLogin = false;
    } else {
      for (String resource : noLoginResources) {
        if (uri.startsWith(resource)) {
          needLogin = false;
          break;
        }
      }
    }

    if (needLogin) {
      return true;
    }
    return true;

  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView)
      throws Exception {
  }


}
