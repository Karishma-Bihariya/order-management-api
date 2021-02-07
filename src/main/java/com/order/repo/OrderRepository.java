package com.order.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.order.entity.OrderDetail;

@Repository
public interface OrderRepository extends ReactiveMongoRepository<OrderDetail, String> {

}
