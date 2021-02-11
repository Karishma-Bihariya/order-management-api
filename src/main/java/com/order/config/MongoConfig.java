package com.order.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

// TODO: Auto-generated Javadoc
/**
 * The Class MongoConfig.
 */
@Configuration
@EnableReactiveMongoRepositories(basePackages = "com.order.repo")
public class MongoConfig extends AbstractReactiveMongoConfiguration {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(MongoConfig.class);

	/** The port. */
	@Value("${port}")
	private String port;

	/** The db name. */
	@Value("${dbname}")
	private String dbName;

	/**
	 * Reactive mongo client.
	 *
	 * @return the mongo client
	 */
	@Override
	public MongoClient reactiveMongoClient() {
		LOGGER.info("Creating mongo client object.");
		return MongoClients.create();
	}

	/**
	 * Gets the database name.
	 *
	 * @return the database name
	 */
	@Override
	protected String getDatabaseName() {
		return dbName;
	}

	/**
	 * Reactive mongo template.
	 *
	 * @return the reactive mongo template
	 */
	@Bean
	public ReactiveMongoTemplate reactiveMongoTemplate() {
		LOGGER.info("Creating ReactiveMongoTemplate object.");
		return new ReactiveMongoTemplate(reactiveMongoClient(), getDatabaseName());

	}
}