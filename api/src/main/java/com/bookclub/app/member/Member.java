package com.bookclub.app.member;

import com.bookclub.app.club.Club;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Member {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  
  private String name;
  private String email;
  private String mobile;
  
  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "club_id")
  private Club club;
  
  
  public Member() {
  }

  public Member(Long id, String name, String mobile, String email, Club club) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.mobile = mobile;
    this.club = club;
  }
  
  public Member(String name, String mobile, String email, Club club) {
    this.name = name;
    this.email = email;
    this.mobile = mobile;
    this.club = club;
  }
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public Club getClub() {
    return club;
  }

  public void setClub(Club club) {
    this.club = club;
  }

  @Override
  public String toString() {
    return "Member [id=" + id + ", name=" + name + ", email=" + email + ", club=" + club + "]";
  }

}
