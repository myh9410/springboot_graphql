package com.example.graphql.controller;

import com.example.graphql.entity.Board;
import com.example.graphql.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @QueryMapping
    public Optional<Board> findByNo(@Argument Long no) {
        return boardService.findByNo(no);
    }

    @MutationMapping
    public Board saveBoard(@Argument String title, @Argument String content) {
        return boardService.saveBoard(title, content);
    }

}
