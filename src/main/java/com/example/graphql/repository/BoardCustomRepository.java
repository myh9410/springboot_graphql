package com.example.graphql.repository;

import com.example.graphql.entity.Board;
import com.example.graphql.entity.QBoard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

@Repository
public class BoardCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;
    private final QBoard board = QBoard.board;

    public BoardCustomRepository(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public Board getBoardByNo(Long no) {
        return jpaQueryFactory.selectFrom(board)
                .where(board.no.eq(no))
                .fetchOne();
    }

}
