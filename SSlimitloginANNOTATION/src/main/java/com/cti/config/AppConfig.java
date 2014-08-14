package com.cti.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.cti.*" })
@PropertySource("classpath:application.properties")
@Import({ SecurityConfig.class })
public class AppConfig {

	// Database Configurations
	private static final String PROPERTY_NAME_DATABASE_DRIVER = "db.driver";

	private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";

	private static final String PROPERTY_NAME_DATABASE_URL = "db.url";

	private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";

	// Hibernate Configurations
	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";

	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";

	private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "com.cti.model.*";

	@Resource
	private Environment env;

	@Bean(name = "dataSource")
	public DataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(env
				.getRequiredProperty(PROPERTY_NAME_DATABASE_DRIVER));

		dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL));

		dataSource.setUsername(env
				.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME));

		dataSource.setPassword(env
				.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));

		return dataSource;
	}

	@Bean
	public SessionFactory sessionFactory() {

		LocalSessionFactoryBuilder sessionFactoryBean = new LocalSessionFactoryBuilder(
				dataSource());

		/*sessionFactoryBean
				.scanPackages(env
						.getRequiredProperty(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN));*/

		sessionFactoryBean.addProperties(hibProperties());

		return sessionFactoryBean.buildSessionFactory();
	}

	private Properties hibProperties() {

		Properties properties = new Properties();

		properties.put(PROPERTY_NAME_HIBERNATE_DIALECT,
				env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));

		properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL,
				env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));

		return properties;
	}

	@Bean
	public HibernateTransactionManager txManager() {
		return new HibernateTransactionManager(sessionFactory());
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setViewClass(JstlView.class);

		viewResolver.setPrefix("/WEB-INF/pages/");

		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

}