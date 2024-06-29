package com.bookclub.app.club;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClubService {
  
  @Autowired
  private ClubRepository clubRepository;

  public List<Club> getAllClubs() {
    return clubRepository.findAll();
  }

  public Club getClubById(Long id) {
    return clubRepository.findById(id)
      .orElseThrow(() -> new IllegalStateException("Club not found"));
  }

  public Club createClub(Club club) {
    return clubRepository.save(club);
  }

  public Club updateClub(Long id, Club club) {
    Club existClub = clubRepository.findById(id)
      .orElseThrow(() -> new IllegalStateException("Club not found"));

    existClub.setName(club.getName());
    existClub.setDescription(club.getDescription());
    return clubRepository.save(existClub);
  }

  public void deleteClub(Long id) {
    boolean exist = clubRepository.existsById(id);
    if(!exist) {
      throw new IllegalStateException("Club not found");
    }
    clubRepository.deleteById(id);
  }
}
