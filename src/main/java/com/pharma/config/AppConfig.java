package com.pharma.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
@ComponentScan({"com.pharma.config.*"})
public class AppConfig {
    @Bean
    PropertyPlaceholderConfigurer getPropertyPlaceholder(){
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
        propertyPlaceholderConfigurer.setLocation(new FileSystemResource(this.getClass().getClassLoader().
                getResource("pharma.properties").getPath()));

        return propertyPlaceholderConfigurer;

    }

   /* @Bean 
    public FreeMarkerConfigurer freemarkerConfig() throws TemplateException { 
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer(); 
        freeMarkerConfigurer.setTemplateLoaderPath("/WEB-INF/views/ftl/");

        Properties settings = new Properties();
        settings.setProperty(freemarker.template.Configuration.TEMPLATE_EXCEPTION_HANDLER_KEY, "rethrow");
        freeMarkerConfigurer.setFreemarkerSettings(settings);
        return freeMarkerConfigurer; 
    }*/

}
