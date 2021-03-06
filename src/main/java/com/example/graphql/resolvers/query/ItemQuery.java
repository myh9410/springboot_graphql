package com.example.graphql.resolvers.query;

import com.example.graphql.dto.response.ItemResponse;
import com.example.graphql.service.ItemService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ItemQuery implements GraphQLQueryResolver {

    private final ItemService itemService;

    public ItemResponse getItemByNo(Long no) {
        return itemService.getItemByNo(no);
    }

    public List<ItemResponse> getAllItems() {
        return itemService.getAllItems();
    }

    public List<ItemResponse> getItemsInType(String type) {
        return itemService.getItemsInType(type);
    }

}
