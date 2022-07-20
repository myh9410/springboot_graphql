package com.example.graphql.resolvers.mutation;

import com.example.graphql.dto.request.ItemRequest;
import com.example.graphql.service.ItemService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ItemMutation implements GraphQLMutationResolver {

    private final ItemService itemService;

    public Long saveItem(ItemRequest itemRequest) {
        return itemService.saveItem(itemRequest);
    }

    public Long putItem(ItemRequest itemRequest) {
        return itemService.putItem(itemRequest);
    }

    public Boolean deleteItem(Long no) {
        return itemService.deleteItem(no);
    }

}
