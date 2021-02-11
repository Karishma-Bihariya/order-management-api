package com.order.test.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.config.AppConfig;
import com.order.config.MongoConfig;
import com.order.config.WebFluxConfig;
import com.order.entity.OrderDetail;
import com.order.service.impl.OrderServiceImpl;

import reactor.core.publisher.Mono;

// TODO: Auto-generated Javadoc
/**
 * The Class OrderServiceImplIntegrationTest.
 */
@RunWith(SpringRunner.class)
@Import({ AppConfig.class, MongoConfig.class, OrderServiceImpl.class, WebFluxConfig.class })
@SpringBootTest
public class OrderServiceImplIntegrationTest {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImplIntegrationTest.class);

	/** The save object id. */
	private static String saveObjectId;

	/** The order service impl. */
	@Autowired
	private OrderServiceImpl orderServiceImpl;

	/** The mongo config. */
	@Autowired
	private MongoConfig mongoConfig;

	/**
	 * Inits the.
	 */
	@Before
	public void init() {
		LOGGER.info("Running junit test for OrderService.");

		mongoConfig.reactiveMongoClient();
		mongoConfig.reactiveMongoTemplate();

	}

	/**
	 * Creates the.
	 */
	@Test
	@Order(1)
	public void create() {
		LOGGER.info("Inserting data into collection.");

		saveObjectId = UUID.randomUUID().toString();

		List<OrderDetail> orderDetailList = new ArrayList<>();

		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrderId(saveObjectId);
		orderDetail.setItemId(UUID.randomUUID().toString());
		orderDetail.setCustomerId(UUID.randomUUID().toString());
		orderDetail.setNote("This is testing note.");
		orderDetail.setOrderTotal(1);
		orderDetail.setQuantity(1);
		orderDetail.setShippingCost(150.00);
		orderDetail.setStatus(1);
		orderDetail.setTimestamp(new Date());

		orderDetailList.add(orderDetail);

		orderServiceImpl.create(orderDetailList);
		LOGGER.info("Insert data successfully.");

	}

	/**
	 * Find by id.
	 */
	@Test
	@Order(2)
	public void findById() {

		try {

			LOGGER.info("Fetching the data by object id : {}." + saveObjectId);

			mongoConfig.reactiveMongoClient();
			mongoConfig.reactiveMongoTemplate();

			Mono<OrderDetail> orderDetailMono = orderServiceImpl.findById(saveObjectId);
			String dataInString = new ObjectMapper().writeValueAsString(orderDetailMono.block());

			LOGGER.info("## Fetched data : {}", dataInString);
			LOGGER.info("Fetching data successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
