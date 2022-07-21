package com.example.graphql.repository.item;

import com.example.graphql.dto.request.ItemRequest;
import com.example.graphql.entity.Item;

import java.util.List;

public interface ItemCustomRepository {
    public Item getItemByNo(Long no);

    List<Item> getAllItems();

    List<Item> getItemsInType(String type);

    Long updateItemByNo(ItemRequest itemRequest);

    Long deleteItemByNo(Long no);
}
