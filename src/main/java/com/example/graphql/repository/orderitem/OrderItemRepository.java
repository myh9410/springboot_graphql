package com.example.graphql.repository.orderitem;

import com.example.graphql.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>, OrderItemCustomRepository {
}
