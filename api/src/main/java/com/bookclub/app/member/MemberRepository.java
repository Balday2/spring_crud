package com.bookclub.app.member;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

  @Query(value = "SELECT * FROM member WHERE email = :query OR name = :query OR mobile =:query", nativeQuery = true)
  List<Member> findByEmailNameOrMobile(String query);
  
}
