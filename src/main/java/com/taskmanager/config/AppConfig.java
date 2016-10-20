package com.taskmanager.config;

import java.util.Properties;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.taskmanager"})
@PropertySource(value = {"classpath:application.properties"})
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
  @Bean(name = "sessionFactory")
  public SessionFactory getSessionFactory(DataSource dataSource) {
    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
    sessionBuilder.scanPackages(env.getRequiredProperty(ENTITYMANAGER_PACKAGES_TO_SCAN));
    sessionBuilder.addProperties(getHibernateProperties());
    return sessionBuilder.buildSessionFactory();
  }

  public Properties getHibernateProperties() {
    Properties properties = new Properties();
    properties.put(HIBERNATE_DIALECT, env.getRequiredProperty(HIBERNATE_DIALECT));
    properties.put(HIBERNATE_SHOW_SQL, env.getRequiredProperty(HIBERNATE_SHOW_SQL));
    properties.put(HIBERNATE_HBM2DDL_AUTO, env.getRequiredProperty(HIBERNATE_HBM2DDL_AUTO));
    properties.put(HIBERNATE_TEMP_USE_JDBC_METADATA_DEFAULTS, env.getRequiredProperty(HIBERNATE_TEMP_USE_JDBC_METADATA_DEFAULTS));
    properties.put(HIBERNATE_DEFAULT_SCHEMA, env.getRequiredProperty(HIBERNATE_DEFAULT_SCHEMA));
    return properties;
  }

  @Autowired
  @Bean(name = "transactionManager")
  public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
    return new HibernateTransactionManager(sessionFactory);
  }

}