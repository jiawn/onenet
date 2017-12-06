package com.cmcc.onenet;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Spring Boot启动主类
 * 
 * @author wannengjia@gmail.com
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableSwagger2
public class Launch {
  private static final Logger logger = LoggerFactory.getLogger(Launch.class);
  /**
   * 应用程序入口
   */
  public static void main(String[] args) {

    new SpringApplicationBuilder()
        .sources(Launch.class)
        .web(true)
        .listeners(new SystemInit())
        .run(args);
    logger.info("项目启动!");
  }
}
