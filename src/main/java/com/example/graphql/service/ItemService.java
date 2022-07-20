package com.example.graphql.service;

import com.example.graphql.dto.request.ItemRequest;
import com.example.graphql.dto.response.ItemResponse;
import com.example.graphql.entity.Item;
import com.example.graphql.repository.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemResponse getItemByNo(Long no) {
        Item item = itemRepository.getItemByNo(no);

        return ItemResponse.builder()
                .item(item)
                .build();
    }

    public List<ItemResponse> getAllItems() {
        return null;
    }

    public List<ItemResponse> getItemsInType(String type) {
        return null;
    }

    public Long saveItem(ItemRequest itemRequest) {
        return null;
    }

    public Long putItem(ItemRequest itemRequest) {
        return null;
    }

    public Boolean deleteItem(Long no) {
        return null;
    }
}
