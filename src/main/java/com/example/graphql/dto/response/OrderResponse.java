package com.example.graphql.dto.response;

import com.example.graphql.dto.enums.OrderStatus;
import com.example.graphql.entity.Order;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderResponse {
    private Long no;
    private String orderNum;
    private LocalDateTime orderDate;
    private OrderStatus status;
    private MemberResponse member;
    private List<OrderItemResponse> orderItems;

    public OrderResponse(Long no, String orderNum, LocalDateTime orderDate, OrderStatus orderStatus) {
        this.no = no;
        this.orderNum = orderNum;
        this.orderDate = orderDate;
        this.status = orderStatus;
    }

    @Builder
    public OrderResponse(Order order) {
        this.no = order.getNo();
        this.orderNum = order.getOrderNum();
        this.orderDate = order.getOrderDate();
        this.status = order.getStatus();
        this.member = new MemberResponse(
                order.getMember().getNo(),
                order.getMember().getUserId(),
                order.getMember().getJoinDate(),
                order.getMember().getActive()
            );
        this.orderItems = order.getOrderItems().stream()
                .map(orderItem ->
                        new OrderItemResponse(
                            orderItem.getNo()
                        )
                )
                .collect(Collectors.toList());
    }
}
