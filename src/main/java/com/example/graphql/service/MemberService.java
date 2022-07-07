package com.example.graphql.service;

import com.example.graphql.entity.Member;
import com.example.graphql.repository.MemberCustomRepository;
import com.example.graphql.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberCustomRepository memberCustomRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Member getMemberByNo(Long no) {
//        Member member = memberRepository.findById(no).orElseThrow(() -> {
//            throw new RuntimeException("에러");
//        });

        Member member = memberCustomRepository.getMemberByNo(no);

//        System.out.println(member.toString());

        return member;
    }

}
