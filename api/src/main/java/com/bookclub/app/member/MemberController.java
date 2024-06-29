package com.bookclub.app.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/member")
public class MemberController {
  
  @Autowired
  private MemberService memberService;

  @GetMapping
  public List<Member> getAllMembers() {
    return memberService.getAllMembers();
  }

  @GetMapping("/{id}")
  public Member getMemberById(@PathVariable Long id) {
    return memberService.getMemberById(id);
  }

  @PostMapping
  public Member createMember(@RequestBody Member member) {
    return memberService.createMember(member);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateMember(@PathVariable Long id, @RequestBody Member member) {
    try {
      memberService.updateMember(id, member);
      return ResponseEntity.ok().body("Success");
    } catch (Exception e) {
      return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteMember(@PathVariable Long id) {
    try {
      memberService.deleteMember(id);
      return ResponseEntity.ok().body("Success");
    } catch (Exception e) {
      return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
    }
  }

  @GetMapping("/search")
  public List<Member> findByEmailNameOrMobile(@RequestParam String query) {
    return memberService.findByEmailNameOrMobile(query);
  }


}
