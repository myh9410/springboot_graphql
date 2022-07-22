package com.example.graphql.entity;

import com.example.graphql.dto.enums.Active;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ToString
@DynamicUpdate
@Builder
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
@Table(name = "members")
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "no")
    private Long no;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "join_date")
    @CreatedDate
    private LocalDateTime joinDate;

    @Column(name = "active")
    @Enumerated(EnumType.STRING)
    private Active active;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

}
