package com.order.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

// TODO: Auto-generated Javadoc
/**
 * The Class AppConfig.
 */
@Configuration
public class AppConfig {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(AppConfig.class);

	/**
	 * Gets the property placeholder configurer.
	 *
	 * @return the property placeholder configurer
	 */
	@Bean
	public static PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer() {
		LOGGER.info("Load application properties and create object");
		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		ppc.setLocation(new ClassPathResource("application.properties"));
		ppc.setIgnoreUnresolvablePlaceholders(true);
		return ppc;
	}
}