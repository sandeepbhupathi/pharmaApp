package com.pharma.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import com.pharma.config.entity.Admin;
import com.pharma.config.entity.CustOrders;
import com.pharma.config.entity.Customer;
import com.pharma.config.entity.DistributerAdmin;

@Configuration
public class HibernateDBConfig {

	@Value("${app.ora.driver}")
	private String  dbDriver;
	
	@Value("${app.ora.url}")
	private String  dbUrl;
	
	@Value("${app.ora.uname}")
	private String  dbUName;
	
	@Value("${app.ora.passwd}")
	private String  dbPasswd;
	
	
	@Bean
	public HibernateTemplate hibernateTemplate() {
		return new HibernateTemplate(sessionFactory());
	}
	@Bean
	public SessionFactory sessionFactory() {
		Properties props = new Properties();
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.hbm2ddl.auto", "update");

		return new LocalSessionFactoryBuilder(getDataSource()).addAnnotatedClasses(Admin.class,Customer.class,
				DistributerAdmin.class,CustOrders.class)
				.mergeProperties(props).buildSessionFactory();
	}
	@Bean
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName(dbDriver);
	    dataSource.setUrl(dbUrl);
	    dataSource.setUsername(dbUName);
	    dataSource.setPassword(dbPasswd);
	    return dataSource;
	}
	@Bean
	public HibernateTransactionManager hibTransMan(){
		 HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	      transactionManager.setSessionFactory(sessionFactory());
	      return transactionManager;
	}
	
}
