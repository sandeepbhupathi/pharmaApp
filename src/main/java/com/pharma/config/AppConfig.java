package com.pharma.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.pharma.config.entity.Admin;
import com.pharma.config.entity.CustOrders;
import com.pharma.config.entity.Customer;
import com.pharma.config.entity.DistributerAdmin;

@Configuration
@ComponentScan({"com.pharma.config.*"})
@EnableTransactionManagement
public class AppConfig {
    @Bean
    PropertyPlaceholderConfigurer getPropertyPlaceholder(){
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
        propertyPlaceholderConfigurer.setLocation(new FileSystemResource(this.getClass().getClassLoader().
                getResource("pharma.properties").getPath()));

        return propertyPlaceholderConfigurer;

    }

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
	    dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	    dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
	    dataSource.setUsername("pharmacy");
	    dataSource.setPassword("pharmacy");
	    return dataSource;
	}
	@Bean
	public HibernateTransactionManager hibTransMan(){
		return new HibernateTransactionManager(sessionFactory());
	}
}
