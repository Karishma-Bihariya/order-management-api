package com.order.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.entity.OrderDetail;
import com.order.repo.OrderRepository;
import com.order.service.OrderService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// TODO: Auto-generated Javadoc
/**
 * The Class OrderServiceImpl.
 */
@Service
public class OrderServiceImpl implements OrderService {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

	/** The order repository. */
	@Autowired(required = true)
	private OrderRepository orderRepository;

	/**
	 * Creates the.
	 *
	 * @param orderList the order list
	 */
	@Override
	public void create(List<OrderDetail> orderList) {
		LOGGER.debug("Input data list size : {}", orderList.size());

		for (OrderDetail orderDetail : orderList) {
			orderRepository.saveAll(Flux.just(orderDetail)).subscribe();
		}

		LOGGER.debug("Data save successfully.");
	}

	/**
	 * Find by id.
	 *
	 * @param objectId the object id
	 * @return the mono
	 */
	@Override
	public Mono<OrderDetail> findById(String objectId) {
		LOGGER.debug("Fetching data by object id : {}", objectId);

		return orderRepository.findById(objectId);

	}

}
