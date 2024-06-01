package com.prac.member.service;

import com.prac.member.dto.MemberDTO;
import com.prac.member.entity.MemberEntity;
import com.prac.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class MemberService {
    private final MemberRepository memberRepository;
    public void save(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);

    }

    public MemberDTO login(MemberDTO memberDTO) {
        Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(memberDTO.getMemberEmail());
        if (byMemberEmail.isPresent()){
            MemberEntity memberEntity = byMemberEmail.get();

            if (memberEntity.getMemberPassword().equals(memberDTO.getMemberPassword())) {
                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
                return dto;
            } else{
                return null;
            }
        } else {
            return null;
        }

    }
}
