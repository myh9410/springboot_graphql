package com.example.graphql.dto.response;

import com.example.graphql.entity.OrderItem;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderItemResponse {
    private Long no;
    private OrderResponse order;
    private ItemResponse item;

    public OrderItemResponse(Long no) {
        this.no = no;
    }

    @Builder
    public OrderItemResponse(OrderItem orderItem) {
        this.no = orderItem.getNo();
        this.order = new OrderResponse(
            orderItem.getOrder().getNo(),
            orderItem.getOrder().getOrderNum(),
            orderItem.getOrder().getOrderDate(),
            orderItem.getOrder().getStatus()
        );
        this.item = new ItemResponse(
            orderItem.getItem().getNo(),
            orderItem.getItem().getName(),
            orderItem.getItem().getType(),
            orderItem.getItem().getPrice()
        );
    }
}
