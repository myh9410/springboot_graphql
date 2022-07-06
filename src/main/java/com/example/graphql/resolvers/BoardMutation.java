package com.example.graphql.resolvers;

import com.example.graphql.entity.Board;
import com.example.graphql.service.BoardService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class BoardMutation implements GraphQLMutationResolver {

    private final BoardService boardService;

    public Board createBoard(Map<String, String> input) {
        return boardService.saveBoard(input.get("title"), input.get("content"));
    }

}
