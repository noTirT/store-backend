package com.tom.selling.artpiece.boundary;

import com.tom.selling.artpiece.entity.ArtPieceDto;
import com.tom.selling.artpiece.control.ArtPieceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
public class ArtPieceController {

    @Autowired
    private ArtPieceService artPieceService;

    @GetMapping("/art/all")
    public ResponseEntity<List<ArtPieceDto>> getAllArtPieces() {
        return new ResponseEntity<>(artPieceService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/art/{id}")
    public ResponseEntity<ArtPieceDto> getArtPieceById(@PathVariable Long id) {
        return new ResponseEntity<>(artPieceService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/art")
    public ResponseEntity<Void> createNewArtPiece(@RequestBody(required = false) ArtPieceDto artPieceDto) {
        if (artPieceDto != null) {
            artPieceService.createNew(artPieceDto);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/art/{id}")
    public ResponseEntity<Void> deleteArtItemById(@PathVariable Long id) {
        artPieceService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/art")
    public ResponseEntity<Void> deleteAllArtItems() {
        artPieceService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/art")
    public ResponseEntity<Void> updateArtItem(@RequestBody ArtPieceDto updatedArtPiece) {
        artPieceService.update(updatedArtPiece);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
