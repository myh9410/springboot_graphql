package com.example.graphql.dto.response;

import com.example.graphql.entity.Item;
import lombok.*;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ItemResponse {
    private Long no;
    private String name;
    private String type;
    private int price;
    private List<OrderItemResponse> orderItems;

    public ItemResponse(Long no, String name, String type, int price) {
        this.no = no;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    @Builder
    public ItemResponse(Item item) {
        this.no = item.getNo();
        this.name = item.getName();
        this.type = item.getType();
        this.price = item.getPrice();
        this.orderItems = item.getOrderItems().stream()
                .map(orderItem ->
                        new OrderItemResponse(
                                orderItem.getNo()
                        )
                )
                .collect(Collectors.toList());

    }
}
