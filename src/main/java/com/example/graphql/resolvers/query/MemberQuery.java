package com.example.graphql.resolvers.query;

import com.example.graphql.dto.response.MemberResponse;
import com.example.graphql.service.MemberService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberQuery implements GraphQLQueryResolver {

    private final MemberService memberService;

    public MemberResponse getMemberByNo(Long no) {
        return memberService.getMemberByNo(no);
    }

}
