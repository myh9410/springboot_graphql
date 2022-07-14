package com.example.graphql.repository.item;

import com.example.graphql.entity.Item;

public interface ItemCustomRepository {
    public Item getItemByNo(Long no);
}
