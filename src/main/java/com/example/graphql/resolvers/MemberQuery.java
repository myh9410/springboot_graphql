package com.example.graphql.resolvers;

import com.example.graphql.entity.Member;
import com.example.graphql.service.MemberService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberQuery implements GraphQLQueryResolver {

    private final MemberService memberService;

    public Member getMemberByNo(Long no) {
        return memberService.getMemberByNo(no);
    }

}
