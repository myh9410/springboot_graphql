package com.example.graphql.service;

import com.example.graphql.dto.request.ItemRequest;
import com.example.graphql.dto.response.ItemResponse;
import com.example.graphql.entity.Item;
import com.example.graphql.repository.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        List<Item> items = itemRepository.getAllItems();

        return items.stream()
                .map(item -> ItemResponse.builder().item(item).build())
                .collect(Collectors.toList());
    }

    public List<ItemResponse> getItemsInType(String type) {
        List<Item> items = itemRepository.getItemsInType(type);

        return items.stream()
                .map(item -> ItemResponse.builder().item(item).build())
                .collect(Collectors.toList());
    }

    public Long saveItem(ItemRequest itemRequest) {
        Item item = itemRepository.save(itemRequest.toEntity());

        return item.getNo();
    }

    public Long putItem(ItemRequest itemRequest) {
        Long updateRows = itemRepository.updateItemByNo(itemRequest);

        System.out.println("update - updatedRows : " + updateRows);

        return itemRequest.getNo();
    }

    public Boolean deleteItem(Long no) {
        Long deleteRows = itemRepository.deleteItemByNo(no);

        System.out.println("delete - deleteRows : " + deleteRows);

        return true;
    }
}
