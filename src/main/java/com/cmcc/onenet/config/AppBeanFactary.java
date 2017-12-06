package com.cmcc.onenet.config;

import com.fasterxml.classmate.TypeResolver;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.annotation.Resource;

import java.time.LocalDate;

import static springfox.documentation.schema.AlternateTypeRules.newRule;

/**
 * 生成特殊bean的工厂bean, 有些第三方的Bean没有标注@component, 需要手工初始化.
 *
 * @author wannengjia@gmail.com
 */
@Configuration
@EnableConfigurationProperties
public class AppBeanFactary {

  @Resource
  private AppConfig appConfig;
  @Autowired
  private TypeResolver typeResolver;

  /**
   * 生成API文档的入口
   */
  @Bean
  public Docket generateApi() {
    Docket docket = null;
    // 可以根据配置决定不做任何API生成
    if (!appConfig.getAllowGenerateApi()) {
      docket = new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.none())
          .build();
    }

    docket = new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        // 标示只有被 @Api 标注的才能生成API.
        .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
        .paths(PathSelectors.any()).build()
        .pathMapping("/")
        .directModelSubstitute(LocalDate.class, String.class)
        // 遇到 LocalDate时，输出成String
        .genericModelSubstitutes(ResponseEntity.class)
        .alternateTypeRules(
            newRule(
                typeResolver.resolve(DeferredResult.class,
                    typeResolver.resolve(ResponseEntity.class, WildcardType.class)),
                typeResolver.resolve(WildcardType.class)))
        .useDefaultResponseMessages(false);
    return docket;
  }

  private ApiInfo apiInfo() {
    return new ApiInfo("中国移动ONENET系统对接接口", "中国移动ONENET系统对接接口", "1.0.0", "", "", "", "");
  }



}
