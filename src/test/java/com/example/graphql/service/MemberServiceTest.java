package com.example.graphql.service;

import com.example.graphql.dto.enums.Active;
import com.example.graphql.dto.request.MemberRequest;
import com.example.graphql.dto.response.MemberResponse;
import com.example.graphql.entity.Member;
import com.example.graphql.repository.member.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {

    @InjectMocks
    MemberService memberService;

    @Mock
    private MemberRepository memberRepository;

    @DisplayName("단일 사용자 조회")
    @Transactional
    @Test
    public void findMemberByNoTest() {
        //given
        MemberRequest memberRequest = createMemberRequest();
        Member member = memberRequest.toEntity();
        MemberResponse memberResponse = createMemberResponse(member);
        given(memberRepository.getMemberByNo(member.getNo())).willReturn(member);

        //when
        MemberResponse actualMemberResponse = memberService.getMemberByNo(member.getNo());

        //then
        assertEquals(actualMemberResponse.getActive(), memberResponse.getActive());
        assertEquals(actualMemberResponse.getUserId(), memberResponse.getUserId());

    }

    private Member createMemberEntity(MemberRequest memberRequest) {
        return Member.builder()
                .userId(memberRequest.getUserId())
                .active(memberRequest.getActive())
                .build();
    }

    private MemberRequest createMemberRequest() {
        MemberRequest memberRequest = new MemberRequest();
        memberRequest.setUserId("test1");
        memberRequest.setActive(Active.Y);
        return memberRequest;
    }

    private MemberResponse createMemberResponse(Member member) {
        return MemberResponse.builder()
                .member(member)
                .build();
    }

}
