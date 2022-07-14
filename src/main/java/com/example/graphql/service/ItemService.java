package com.example.graphql.service;

import com.example.graphql.dto.response.ItemResponse;
import com.example.graphql.entity.Item;
import com.example.graphql.repository.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

}
