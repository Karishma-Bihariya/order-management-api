package com.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// TODO: Auto-generated Javadoc
/**
 * The Class OrderSpringApplication.
 */
@SpringBootApplication
public class OrderSpringApplication extends SpringBootServletInitializer {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderSpringApplication.class);

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		LOGGER.info("Starting Order Web Application.");
		SpringApplication.run(OrderSpringApplication.class, args);
		LOGGER.info("Order Web Application has started.");

	}

	/**
	 * Configure.
	 *
	 * @param builder the builder
	 * @return the spring application builder
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(OrderSpringApplication.class);
	}
}
