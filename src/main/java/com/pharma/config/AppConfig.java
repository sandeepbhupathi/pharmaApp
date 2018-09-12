package com.pharma.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"com.pharma.config.*"})
@EnableTransactionManagement
@Import(HibernateDBConfig.class)
public class AppConfig {
	
    @Bean
    PropertyPlaceholderConfigurer getPropertyPlaceholder(){
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
        propertyPlaceholderConfigurer.setLocation(new FileSystemResource(this.getClass().getClassLoader().
                getResource("pharma.properties").getPath()));

        return propertyPlaceholderConfigurer;

    }
}
