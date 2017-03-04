package com.taskmanager.config;

import java.util.Properties;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.taskmanager.repository"}, entityManagerFactoryRef = "entityManagerFactory")
@ComponentScan("com.taskmanager")
@PropertySource(value = {"classpath:config/application.properties"})
public class AppConfig {

  private static final String DB_DRIVER = "db.driver";
  private static final String DB_PASSWORD = "db.password";
  private static final String DB_URL = "db.url";
  private static final String DB_USERNAME = "db.username";
  private static final String HIBERNATE_DIALECT = "hibernate.dialect";
  private static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
  private static final String ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";
  private static final String HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
  private static final String HIBERNATE_TEMP_USE_JDBC_METADATA_DEFAULTS = "hibernate.temp.use_jdbc_metadata_defaults";
  private static final String HIBERNATE_DEFAULT_SCHEMA = "hibernate.default_schema";

  @Resource
  private Environment env;

  @Bean(name = "dataSource")
  public DataSource getDataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setDriverClassName(env.getRequiredProperty(DB_DRIVER));
    dataSource.setUrl(env.getRequiredProperty(DB_URL));
    dataSource.setUsername(env.getRequiredProperty(DB_USERNAME));
    dataSource.setPassword(env.getRequiredProperty(DB_PASSWORD));
    return dataSource;
  }

  @Autowired
  @Bean(name = "entityManagerFactory")
  LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Properties hibernateProperties) {
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
    entityManagerFactoryBean.setDataSource(dataSource);
    entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    entityManagerFactoryBean.setPackagesToScan(env.getRequiredProperty(ENTITYMANAGER_PACKAGES_TO_SCAN));
    entityManagerFactoryBean.setJpaProperties(hibernateProperties);
    return entityManagerFactoryBean;
  }

  @Autowired
  @Bean(name = "transactionManager")
  JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactory);
    return transactionManager;
  }

  @Bean(name = "hibernateProperties")
  public Properties getHibernateProperties() {
    Properties properties = new Properties();
    properties.put(HIBERNATE_DIALECT, env.getRequiredProperty(HIBERNATE_DIALECT));
    properties.put(HIBERNATE_SHOW_SQL, env.getRequiredProperty(HIBERNATE_SHOW_SQL));
    properties.put(HIBERNATE_HBM2DDL_AUTO, env.getRequiredProperty(HIBERNATE_HBM2DDL_AUTO));
    properties.put(HIBERNATE_TEMP_USE_JDBC_METADATA_DEFAULTS, env.getRequiredProperty(HIBERNATE_TEMP_USE_JDBC_METADATA_DEFAULTS));
    properties.put(HIBERNATE_DEFAULT_SCHEMA, env.getRequiredProperty(HIBERNATE_DEFAULT_SCHEMA));
    return properties;
  }

}