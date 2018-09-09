package com.pharma.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class PharmaAppInit implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext ();
        applicationContext.register(AppConfig.class);
        //applicationContext.registerShutdownHook();

        servletContext.addListener(new ContextLoaderListener(applicationContext));
        FilterRegistration.Dynamic strutsFilter = servletContext.addFilter(
                "StrutsDispatcher", new StrutsPrepareAndExecuteFilter());
        strutsFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
        
        
    }
}
