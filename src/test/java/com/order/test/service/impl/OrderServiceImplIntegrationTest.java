package com.order.test.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.order.config.AppConfig;
import com.order.config.MongoConfig;
import com.order.config.WebFluxConfig;
import com.order.entity.OrderDetail;
import com.order.service.impl.OrderServiceImpl;

@RunWith(SpringRunner.class)
@Import({ AppConfig.class, MongoConfig.class, OrderServiceImpl.class, WebFluxConfig.class })
@SpringBootTest
public class OrderServiceImplIntegrationTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImplIntegrationTest.class);

	@Autowired
	private OrderServiceImpl orderServiceImpl;

	@Autowired
	private MongoConfig mongoConfig;

	@Autowired
	private WebFluxConfig webFluxConfig;

	@Test
	public void create() {
		LOGGER.info("Running junit test for OrderService.");

		mongoConfig.reactiveMongoClient();
		mongoConfig.reactiveMongoTemplate();

		List<OrderDetail> orderDetailList = new ArrayList<>();

		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrderId(UUID.randomUUID().toString());
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
		LOGGER.info("Run junit test successfully for OrderService.");

	}

}
