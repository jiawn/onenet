package com.cmcc.onenet.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * 与当前应用相关的配置信息。说明：1、ConfigurationProperties中prefix，为application.yml文件中app定义的值
 * 
 * <pre>
 * 
 * @author wannengjia@gmail.com
 */
@ConfigurationProperties(prefix = "app")
@Component
public class AppConfig {

  /**
   * 应用名称
   */
  private String appName;
  /**
   * 是否允许跨域
   */
  private Boolean allowCrossDomainAccess;
  /**
   * 是否允许生成API文档
   */
  private Boolean allowGenerateApi;

  public String getAppName() {
    return appName;
  }

  public void setAppName(String appName) {
    this.appName = appName;
  }

  public Boolean getAllowCrossDomainAccess() {
    return allowCrossDomainAccess;
  }

  public void setAllowCrossDomainAccess(Boolean allowCrossDomainAccess) {
    this.allowCrossDomainAccess = allowCrossDomainAccess;
  }

  public Boolean getAllowGenerateApi() {
    return allowGenerateApi;
  }

  public void setAllowGenerateApi(Boolean allowGenerateApi) {
    this.allowGenerateApi = allowGenerateApi;
  }
}
