package com.example.graphql.service;

import com.example.graphql.entity.Board;
import com.example.graphql.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Board getBoardByNo(Long no) {
        return boardRepository.findById(no).orElseThrow();
    }

    public Board saveBoard(String title, String content) {
        Board board = Board.builder()
                .title(title)
                .content(content)
                .build();

        return boardRepository.save(board);
    }

}
