package com.example.graphql.entity;

import com.example.graphql.dto.enums.YorN;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;

@Slf4j
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "board_test")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no")
    private long no;

    private String title;

    private String content;

}