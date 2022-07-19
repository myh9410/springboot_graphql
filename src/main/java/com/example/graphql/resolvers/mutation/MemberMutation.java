package com.example.graphql.resolvers.mutation;

import com.example.graphql.dto.request.MemberRequest;
import com.example.graphql.service.MemberService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberMutation implements GraphQLMutationResolver {

    private final MemberService memberService;

    public Long saveMember(MemberRequest memberRequest) {
        return memberService.saveMember(memberRequest);
    }

    public Long putMember(MemberRequest memberRequest) {
        return memberService.saveMember(memberRequest);
    }

    public Boolean deleteMember(MemberRequest memberRequest) {
        return true;
    }

}
