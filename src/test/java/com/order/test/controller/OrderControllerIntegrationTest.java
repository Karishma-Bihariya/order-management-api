package com.order.test.controller;

import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.order.OrderSpringApplication;
import com.order.test.service.impl.OrderServiceImplIntegrationTest;

// TODO: Auto-generated Javadoc
/**
 * The Class OrderControllerIntegrationTest.
 */
@RunWith(SpringRunner.class)

@SpringBootTest(classes = OrderSpringApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class OrderControllerIntegrationTest {

	/** The logger. */
	private final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImplIntegrationTest.class);

	/** The header content type. */
	private final String HEADER_CONTENT_TYPE = "Content-Type";

	/** The header content type value. */
	private final String HEADER_CONTENT_TYPE_VALUE = "application/json";

	/** The api url. */
	private final String createApiUrl = "/orders/add";

	/** The find by id api url. */
	private final String findByIdApiUrl = "/orders/findById?objectId=";

	/** The base URL. */
	private String baseURL;

	/** The test json. */
	private String testJson = "[\n" + "   {\n" + "      \"orderId\":\"401a85e2-f5da-494b-9f3f-756a91982f00\",\n"
			+ "      \"timestamp\":1612487464353,\n" + "      \"status\":0,\n" + "      \"orderTotal\":10.23,\n"
			+ "      \"shippingCost\":3.45,\n" + "      \"customerId\":\"401a85e2-f5da-494b-9f3f-756a91982f01\",\n"
			+ "      \"itemId\":\"401a85e2-f5da-494b-9f3f-756a91982f02\",\n" + "      \"quantity\":1,\n"
			+ "      \"note\":\"test999\"\n" + "   },\n" + "   {\n"
			+ "      \"orderId\":\"401a85e2-f5da-494b-9f3f-756a91982f01\",\n" + "      \"timestamp\":1612487464353,\n"
			+ "      \"status\":0,\n" + "      \"orderTotal\":10.23,\n" + "      \"shippingCost\":3.45,\n"
			+ "      \"customerId\":\"401a85e2-f5da-494b-9f3f-756a91982f85\",\n"
			+ "      \"itemId\":\"401a85e2-f5da-494b-9f3f-756a91972f02\",\n" + "      \"quantity\":1,\n"
			+ "      \"note\":\"test888\"\n" + "   }\n" + "]";

	/** The random server port. */
	@LocalServerPort
	int randomServerPort;

	/**
	 * Inits the.
	 */
	@Before
	public void init() {
		try {
			LOGGER.info("Running junit test for Order Controller.");

			baseURL = InetAddress.getLocalHost().getHostAddress() + ":" + randomServerPort;
			LOGGER.error("baseURL : {}", baseURL);

		} catch (UnknownHostException e) {
			LOGGER.error("Failed to set baseURL due to : {}", e.getMessage(), e);
		}
	}

	/**
	 * Creates the.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void create() throws Exception {
		LOGGER.info("Inserting data using Order Controller.");

		RestTemplate restTemplate = new RestTemplate();

		URI uri = new URI("http://" + baseURL + createApiUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.set(HEADER_CONTENT_TYPE, HEADER_CONTENT_TYPE_VALUE);
		LOGGER.info("URI: {}", uri);

		HttpEntity<String> request = new HttpEntity<>(testJson, headers);
		ResponseEntity<Object> response = restTemplate.postForEntity(uri, request, Object.class);
		LOGGER.info("Status: {}", response.getStatusCode());

		LOGGER.info("Insert data successfull.");

	}

	/**
	 * Find by id.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void findById() throws Exception {
		LOGGER.info("Fetching data using Order Controller.");

		String savedObjectId = "401a85e2-f5da-494b-9f3f-756a91982f00";

		RestTemplate restTemplate = new RestTemplate();

		URI uri = new URI("http://" + baseURL + findByIdApiUrl + savedObjectId);
		LOGGER.info("URI: {}", uri);

		ResponseEntity<Object> response = restTemplate.getForEntity(uri, Object.class);
		LOGGER.info("Response Status: {}", response.getStatusCode());
		LOGGER.info("Response Body: {}", response.getBody());

		LOGGER.info("Fetched data successfull.");

	}

}
