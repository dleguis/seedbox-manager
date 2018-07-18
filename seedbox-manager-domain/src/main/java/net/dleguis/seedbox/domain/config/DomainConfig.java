package net.dleguis.seedbox.domain.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("net.dleguis.seedbox.domain.repository")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class DomainConfig {

	@Resource
	private Environment env;

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;
	@Value("${spring.datasource.password}")
	private String dialect;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;

	@Bean
	// (destroyMethod = "close")
	DataSource dataSource() {
		DriverManagerDataSource dataSourceConfig = new DriverManagerDataSource();
		dataSourceConfig.setUrl(url);
		dataSourceConfig.setDriverClassName(driverClassName);
		dataSourceConfig.setUsername(username);
		dataSourceConfig.setPassword(password);
		return dataSourceConfig;
	}

	/**
	 * The method that configures the entity manager factory
	 * */
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Environment env) {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setPackagesToScan("net.dleguis.seedbox.domain");

		Properties jpaProperties = new Properties();

		// jpaProperties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
		// jpaProperties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
		// jpaProperties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
		// jpaProperties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));

		entityManagerFactoryBean.setJpaProperties(jpaProperties);

		return entityManagerFactoryBean;
	}

	/**
	 * The method that configures the transaction manager
	 * */
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
}
