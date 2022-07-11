package com.example.graphql.service;

import com.example.graphql.entity.Item;
import com.example.graphql.repository.ItemCustomRepository;
import com.example.graphql.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemCustomRepository itemCustomRepository;
    private final ItemRepository itemRepository;

    public Item getItemByNo(Long no) {
        Item item = itemCustomRepository.getItemByNo(no);

        return item;
    }

}
