package com.order.service;

import java.util.List;

import com.order.entity.OrderDetail;

public interface OrderService {

	void create(List<OrderDetail> e);
}
