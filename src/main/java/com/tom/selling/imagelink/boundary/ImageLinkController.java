package com.tom.selling.imagelink.boundary;

import com.tom.selling.imagelink.entity.ImageLinkDto;
import com.tom.selling.imagelink.control.ImageLinkService;
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
public class ImageLinkController {

    @Autowired
    private ImageLinkService imageLinkService;

    @GetMapping("/image-link/all")
    public ResponseEntity<List<ImageLinkDto>> getAllImageLinks() {
        return new ResponseEntity<>(imageLinkService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/image-link/{id}")
    public ResponseEntity<ImageLinkDto> getImageLinkById(@PathVariable Long id) {
        return new ResponseEntity<>(imageLinkService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/image-link")
    public ResponseEntity<Void> createNewImageLink(@RequestBody(required = false) ImageLinkDto imageLinkDto) {
        if (imageLinkDto != null) {
            imageLinkService.createNew(imageLinkDto);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/image-link/all")
    public ResponseEntity<Void> deleteAllImageLinks() {
        imageLinkService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/image-link/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        imageLinkService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/image-link")
    public ResponseEntity<Void> updateImageLink(@RequestBody ImageLinkDto updatedImageLink) {
        imageLinkService.update(updatedImageLink);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
