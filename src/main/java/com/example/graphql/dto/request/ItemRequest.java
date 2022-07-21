package com.example.graphql.dto.request;

import com.example.graphql.entity.Item;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequest {
    private Long no;
    private String name;
    private String type;
    private int price;

    public Item toEntity() {
        return Item.builder()
                .name(name)
                .type(type)
                .price(price)
                .build();
    }
}
