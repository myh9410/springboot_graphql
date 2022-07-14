package com.example.graphql.service;

import com.example.graphql.dto.response.MemberResponse;
import com.example.graphql.entity.Member;
import com.example.graphql.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberResponse getMemberByNo(Long no) {
        Member member = memberRepository.getMemberByNo(no);

        //비즈니스 로직

        return MemberResponse.builder()
                .member(member)
                .build();
    }

}
