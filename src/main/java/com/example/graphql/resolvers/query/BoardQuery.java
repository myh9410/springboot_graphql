package com.example.graphql.resolvers.query;

import com.example.graphql.entity.Board;
import com.example.graphql.service.BoardService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BoardQuery implements GraphQLQueryResolver {

    private final BoardService boardService;

    public Board getBoardByNo(Long no) {
        return boardService.getBoardByNo(no);
    }

}
