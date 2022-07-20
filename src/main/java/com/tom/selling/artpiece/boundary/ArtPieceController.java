package com.tom.selling.artpiece.boundary;

import com.tom.selling.artpiece.entity.ArtPieceDto;
import com.tom.selling.artpiece.control.ArtPieceService;
import com.tom.selling.artpiece.entity.ArtPieceRequest;
import com.tom.selling.artpiece.entity.ArtPieceResponse;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/art")
public class ArtPieceController {

    @Autowired
    private ArtPieceService artPieceService;

    @GetMapping("/all")
    public ResponseEntity<List<ArtPieceResponse>> getAllArtPieces() {
        return new ResponseEntity<>(artPieceService.getAll().stream().map(ArtPieceResponse::of).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtPieceResponse> getArtPieceById(@PathVariable Long id) {
        return new ResponseEntity<>(ArtPieceResponse.of(artPieceService.getById(id)), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Void> createNewArtPiece(@RequestBody(required = false) ArtPieceRequest request) {
        if (request != null) {
            artPieceService.createNew(request);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArtItemById(@PathVariable Long id) {
        artPieceService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Void> updateArtItem(@RequestBody ArtPieceDto updatedArtPiece) {
        artPieceService.update(updatedArtPiece);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
