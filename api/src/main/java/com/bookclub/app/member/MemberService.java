package com.bookclub.app.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
  
  @Autowired
  private MemberRepository memberRepository;

  public List<Member> getAllMembers() {
    return memberRepository.findAll();
  }

  public Member getMemberById(Long id) {
    return memberRepository.findById(id)
      .orElseThrow(() -> new IllegalStateException("Member not found"));
  }

  public Member createMember(Member member) {
    return memberRepository.save(member);
  }

  public Member updateMember(Long id, Member member) {
    Member existMember = memberRepository.findById(id)
      .orElseThrow(() -> new IllegalStateException("Member not found"));

    existMember.setName(member.getName());
    existMember.setEmail(member.getEmail());
    existMember.setMobile(member.getMobile());
    existMember.setClub(member.getClub());

    return memberRepository.save(existMember);
  }

  public void deleteMember(Long id) {
    boolean exist = memberRepository.existsById(id);
    if(!exist) {
      throw new IllegalStateException("Member not found");
    }
    memberRepository.deleteById(id);
  }

  // public List<Member> getMembersByClubId(Long clubId) {
  //   return memberRepository.findByClubId(clubId);
  // }

  public List<Member> findByEmailNameOrMobile(String query) {
    return memberRepository.findByEmailNameOrMobile(query);
  }
}
