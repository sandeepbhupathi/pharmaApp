package com.pharma.config;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
public class AppContextInit implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		 ConfigurableEnvironment environment = applicationContext.getEnvironment();
		 environment.setDefaultProfiles("pharma");
		
	}

}
