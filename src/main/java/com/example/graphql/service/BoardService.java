package com.example.graphql.service;

import com.example.graphql.entity.Board;
import com.example.graphql.repository.BoardRepository;
import com.example.graphql.repository.BoardCustomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardCustomRepository boardCustomRepository;
    private final BoardRepository boardRepository;

    public Board getBoardByNo(Long no) {
        return boardCustomRepository.getBoardByNo(no);
    }

    public Board saveBoard(String title, String content) {
        Board board = Board.builder()
                .title(title)
                .content(content)
                .build();

        return boardRepository.save(board);
    }

}
