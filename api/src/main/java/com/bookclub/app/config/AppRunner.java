package com.bookclub.app.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bookclub.app.club.Club;
import com.bookclub.app.club.ClubRepository;
import com.bookclub.app.member.Member;
import com.bookclub.app.member.MemberRepository;

@Configuration
public class AppRunner {
  
  @Bean
  CommandLineRunner commandLineRunner(
    ClubRepository clubRepository,
    MemberRepository memberRepository
  ) {
    return args -> {
      Club club1 = new Club(
        "Java Book Club",
        "A group of Java enthusiasts"
      );

      Club club2 = new Club(
        "Python Book Club",
        "A group of Python enthusiasts"
      );

      Club club3 = new Club(
        "LARAVEL Book Club",
        "A group of LARAVEL enthusiasts"
      );

      Club club4 = new Club(
        "flutter Book Club",
        "A group of flutter enthusiasts"
      );
      clubRepository.saveAll(List.of(club1, club2, club3, club4));

      
      Member member1 = new Member(
        "Jane",
        "6251122335",
        "jane@gmail.com",
        club1
      );

      Member member2 = new Member(
        "John",
        "621078833",
        "jhon@gmail.com",
        club1
      );

      Member member3 = new Member(
        "Jill",
        "66616932",
        "jill@gmail.com",
        club2
      );

      Member member4 = new Member(
        "bilal",
        "655950023",
        "bilal@gmail.com",
        club3
      );

      Member member5 = new Member(
        "mahmud",
        "628040894",
        "mahmud@gmail.com",
        club1
      );

      Member member6 = new Member(
        "mahmud",
        "622919637",
        "mahmud@gmail.com",
        club2
      );


      memberRepository.saveAll(List.of(member1, member2, member3, member4, member5, member6));
    };
  }
}
