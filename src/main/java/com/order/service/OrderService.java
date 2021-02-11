package com.order.service;

import java.util.List;

import com.order.entity.OrderDetail;

import reactor.core.publisher.Mono;

// TODO: Auto-generated Javadoc
/**
 * The Interface OrderService.
 */
public interface OrderService {

	/**
	 * Creates the.
	 *
	 * @param e the e
	 */
	public void create(List<OrderDetail> e);

	/**
	 * Find by id.
	 *
	 * @param objectId the object id
	 * @return the mono
	 */
	public Mono<OrderDetail> findById(String objectId);
}
