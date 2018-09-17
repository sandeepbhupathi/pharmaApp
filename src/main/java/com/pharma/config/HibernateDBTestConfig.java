package com.pharma.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.pharma.config.entity.Admin;
import com.pharma.config.entity.CustOrders;
import com.pharma.config.entity.Customer;
import com.pharma.config.entity.DistributerAdmin;

@Configuration
@Profile("pharmaTest")
@ComponentScan(basePackages={"com.pharma.config.*"})
@EnableTransactionManagement
public class HibernateDBTestConfig {
	@Value("${app.ora.test.driver}")
	private String  dbDriver;
	
	@Value("${app.ora.test.url}")
	private String  dbUrl;
	
	@Value("${app.ora.test.uname}")
	private String  dbUName;
	
	@Value("${app.ora.test.passwd}")
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
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2).setName("test_sa")
				.addScript("schema.sql")
				.addScript("data.sql").build();
	}
	@Bean
	public HibernateTransactionManager hibTransMan(){
		 HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	      transactionManager.setSessionFactory(sessionFactory());
	      return transactionManager;
	}
}
