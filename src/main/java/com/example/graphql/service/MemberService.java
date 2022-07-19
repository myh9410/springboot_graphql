package com.example.graphql.service;

import com.example.graphql.dto.request.MemberRequest;
import com.example.graphql.dto.response.MemberResponse;
import com.example.graphql.entity.Member;
import com.example.graphql.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<MemberResponse> getAllMembers() {
        List<Member> members = memberRepository.getAllMembers();

        //비즈니스 로직

        return members.stream()
                .map(member -> MemberResponse.builder().member(member).build())
                .collect(Collectors.toList());
    }

    public Long saveMember(MemberRequest memberRequest) {
        Member member = memberRepository.save(memberRequest.toEntity());

        //비즈니스 로직

        return member.getNo();
    }

    //todo
    public Long putMember(MemberRequest memberRequest) {
        Member member = memberRepository.save(memberRequest.toEntity());

        //비즈니스 로직

        return member.getNo();
    }

    //todo
    public Long deleteMember(MemberRequest memberRequest) {
        Member member = memberRepository.save(memberRequest.toEntity());

        //비즈니스 로직

        return member.getNo();
    }

}
