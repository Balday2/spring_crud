package com.bookclub.app.club;

import java.util.List;

import com.bookclub.app.member.Member;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Club {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String description;

  @JsonManagedReference
  @OneToMany(mappedBy = "club", cascade = CascadeType.ALL)
  private List<Member> members;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Member> getMembers() {
    return members;
  }

  public void setMembers(List<Member> members) {
    this.members = members;
  }

  @Override
  public String toString() {
    return "Club [id=" + id + ", name=" + name + ", description=" + description + ", members=" + members + "]";
  }

  public Club() { }

  public Club(String name, String description) {
    super();
    this.name = name;
    this.description = description;
  }

  public Club(Long id, String name, String description) {
    super();
    this.id = id;
    this.name = name;
    this.description = description;
  }
}
