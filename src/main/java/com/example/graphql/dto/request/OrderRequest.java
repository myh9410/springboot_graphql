package com.example.graphql.dto.request;

import com.example.graphql.dto.enums.OrderStatus;
import com.example.graphql.entity.Member;
import com.example.graphql.entity.Order;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private String order_num;
    private OrderStatus status;

    public Order toEntity() {
        return Order.builder()
                .member(Member.builder().no(1L).build())
                .orderNum(order_num)
                .status(status)
                .build();
    }
}
