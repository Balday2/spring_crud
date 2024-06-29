package com.bookclub.app.club;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/club")
public class ClubController {

  @Autowired
  private ClubService clubService;

  @GetMapping
  public List<Club> getAllClubs() {
    return clubService.getAllClubs();
  }

  @GetMapping("/{id}")
  public Club getClubById(@PathVariable Long id) {
    return clubService.getClubById(id);
  }

  @PostMapping
  public Club createClub(@RequestBody Club club) {
    return clubService.createClub(club);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateClub(
    @PathVariable Long id,
    @RequestBody Club club
  ) {
    try {
      clubService.updateClub(id, club);
      return ResponseEntity.ok().body("Success");
    } catch (Exception e) {
      return ResponseEntity
        .status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteClub(@PathVariable Long id) {
     try {
        clubService.deleteClub(id);
        return ResponseEntity.ok().body("Success");
      } catch (Exception e) {
        return ResponseEntity
          .status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
      }
  }


  
}
