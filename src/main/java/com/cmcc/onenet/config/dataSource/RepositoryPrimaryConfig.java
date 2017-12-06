package com.cmcc.onenet.config.dataSource;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * 
 * @author wannengjia@gmail.com
 * <pre>
 * 配置主数据源  用来访问本地数据库
 * </pre>
 */
@Configuration
//@EnableTransactionManagement
@MapperScan(basePackages = {"com.cmcc.onenet.mapper"}, sqlSessionFactoryRef = "sqlSessionFactory1")
public class RepositoryPrimaryConfig {

  @Autowired
  @Qualifier("db1")
  private DataSource dynamicDataSource;

  @Bean
  public SqlSessionFactory sqlSessionFactory1() throws Exception {
      SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
      factoryBean.setDataSource(dynamicDataSource); // 使用db1数据源, 连接db1库
      return factoryBean.getObject();

  }

  @Bean
  public SqlSessionTemplate sqlSessionTemplate1() throws Exception {
      SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory1()); // 使用上面配置的Factory
    org.apache.ibatis.session.Configuration configuration = template.getConfiguration();
    configuration.setMapUnderscoreToCamelCase(true);
    configuration.setUseGeneratedKeys(true);
    configuration.setDefaultExecutorType(ExecutorType.BATCH);
    return template;
  }
}