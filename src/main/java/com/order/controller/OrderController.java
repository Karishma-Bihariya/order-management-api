package com.order.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.order.entity.OrderDetail;
import com.order.service.OrderService;

import reactor.core.publisher.Mono;

// TODO: Auto-generated Javadoc
/**
 * The Class OrderController.
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

	/** The order service. */
	@Autowired
	private OrderService orderService;

	/**
	 * Creates the.
	 *
	 * @param orderList the order list
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody List<OrderDetail> orderList) {
		LOGGER.info("Saving order details.");
		orderService.create(orderList);
	}

	/**
	 * Find by id.
	 *
	 * @param objectId the object id
	 * @return the mono
	 */
	@RequestMapping(value = "/findById", method = RequestMethod.GET, produces = "application/json")
	@ResponseStatus(HttpStatus.FOUND)
	public Mono<OrderDetail> findById(@RequestParam("objectId") String objectId) {
		LOGGER.info("Fetching data by object id : {}", objectId);

		Mono<OrderDetail> orderDetailMono = orderService.findById(objectId);

		return orderDetailMono;
	}

}
