package com.example.graphql.service;

import com.example.graphql.RandomHelper;
import com.example.graphql.dto.response.MemberResponse;
import com.example.graphql.entity.Member;
import com.example.graphql.repository.member.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {

    @InjectMocks
    private MemberService memberService;

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private Member member;

    @DisplayName("단일 사용자 조회")
    @Transactional
    @Test
    public void findMemberByNoTest() {
        //given

        //when
//        when(memberService.getMemberByNo(no)).thenReturn(memberResponse);
//        memberService.getMemberByNo(no);

        //then
//        Mockito.verify(memberRepository, Mockito.times(1)).getMemberByNo(no);

    }

}
