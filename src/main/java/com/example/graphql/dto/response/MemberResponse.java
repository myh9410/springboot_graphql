package com.example.graphql.dto.response;

import com.example.graphql.dto.enums.Active;
import com.example.graphql.entity.Member;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberResponse {
    private Long no;
    private String userId;
    private LocalDateTime joinDate;
    private Active active;
    private List<OrderResponse> orders;

    public MemberResponse(Long no, String userId, LocalDateTime joinDate, Active active) {
        this.no = no;
        this.userId = userId;
        this.joinDate = joinDate;
        this.active = active;
    }

    @Builder
    public MemberResponse(Member member) {
        this.no = member.getNo();
        this.userId = member.getUserId();
        this.joinDate = member.getJoinDate();
        this.active = member.getActive();
        this.orders = member.getOrders().stream()
                            .map(order ->
                                new OrderResponse(
                                        order.getNo(),
                                        order.getOrderNum(),
                                        order.getOrderDate(),
                                        order.getStatus()
                                )
                            )
                            .collect(Collectors.toList());
    }
}
