package com.order.test.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.order.config.AppConfig;
import com.order.config.MongoConfig;
import com.order.config.WebFluxConfig;
import com.order.controller.OrderController;
import com.order.entity.OrderDetail;
import com.order.repo.OrderRepository;
import com.order.service.impl.OrderServiceImpl;
import com.order.test.service.impl.OrderServiceImplIntegrationTest;

@RunWith(SpringRunner.class)
@Import({ AppConfig.class, MongoConfig.class, OrderController.class, OrderServiceImpl.class, WebFluxConfig.class })
@WebMvcTest
@SpringBootTest
public class OrderControllerIntegrationTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImplIntegrationTest.class);

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private OrderController orderController;

	@Autowired
	private MongoConfig mongoConfig;


	String exampleCourseJson = "[\n" + "   {\n" + "      \"orderId\":\"401a85e2-f5da-494b-9f3f-756a91982f00\",\n"
			+ "      \"timestamp\":1612487464353,\n" + "      \"status\":0,\n" + "      \"orderTotal\":10.23,\n"
			+ "      \"shippingCost\":3.45,\n" + "      \"customerId\":\"401a85e2-f5da-494b-9f3f-756a91982f01\",\n"
			+ "      \"itemId\":\"401a85e2-f5da-494b-9f3f-756a91982f02\",\n" + "      \"quantity\":1,\n"
			+ "      \"note\":\"test999\"\n" + "   },\n" + "   {\n"
			+ "      \"orderId\":\"401a85e2-f5da-494b-9f3f-756a91982f01\",\n" + "      \"timestamp\":1612487464353,\n"
			+ "      \"status\":0,\n" + "      \"orderTotal\":10.23,\n" + "      \"shippingCost\":3.45,\n"
			+ "      \"customerId\":\"401a85e2-f5da-494b-9f3f-756a91982f85\",\n"
			+ "      \"itemId\":\"401a85e2-f5da-494b-9f3f-756a91972f02\",\n" + "      \"quantity\":1,\n"
			+ "      \"note\":\"test888\"\n" + "   }\n" + "]";

	@Test
	public void create() {
		try {
			LOGGER.info("Running junit test for Order Controller.");

			mongoConfig.reactiveMongoClient();
			mongoConfig.reactiveMongoTemplate();

			MockHttpServletRequest request = new MockHttpServletRequest();
			RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

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

			orderController.create(orderDetailList);

			
			LOGGER.info("Run junit test successfully for Order Controller.");
		} catch (

		Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
