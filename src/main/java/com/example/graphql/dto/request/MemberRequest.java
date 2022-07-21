package com.example.graphql.dto.request;

import com.example.graphql.dto.enums.Active;
import com.example.graphql.entity.Member;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberRequest {
    private Long no;
    private String userId;
    private Active active;

    public Member toEntity() {
        return Member.builder()
                .userId(userId)
                .active(active)
                .build();
    }
}
