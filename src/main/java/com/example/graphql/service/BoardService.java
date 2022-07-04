package com.example.graphql.service;

import com.example.graphql.entity.Board;
import com.example.graphql.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Optional<Board> findByNo(Long no) {
        return boardRepository.findById(no);
    }

    public Board saveBoard(String title, String content) {
        Board board = Board.builder()
                .title(title)
                .content(content)
                .build();

        return boardRepository.save(board);
    }

}
