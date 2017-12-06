/**
 * 
 */
package com.cmcc.onenet.config.dataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author wannengjia@gmail.com
 *
 */
@Configuration
public class DataSourceConfig {

  @Bean(name = "db1")
  @Primary
  // 指定配置前缀，与application.properties中对应
  @ConfigurationProperties(prefix = "spring.datasource.primary")
  public DataSource primaryDataSource() {
    return DataSourceBuilder.create().build();
  }

  
}
