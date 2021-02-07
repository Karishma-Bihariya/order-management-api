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

@Service
public class OrderServiceImpl implements OrderService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired(required = true)
	private OrderRepository orderRepository;

	@Override
	public void create(List<OrderDetail> orderList) {

		for (OrderDetail orderDetail : orderList) {
			orderRepository.saveAll(Flux.just(orderDetail)).subscribe();
		}

		LOGGER.info("Data save successfully.");
	}

}
