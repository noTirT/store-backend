package com.tom.selling.imagelink.boundary;

import com.tom.selling.imagelink.entity.ImageLinkDto;
import com.tom.selling.imagelink.control.ImageLinkService;
import com.tom.selling.imagelink.entity.ImageLinkResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/image-link")
public class ImageLinkController {

    @Autowired
    private ImageLinkService imageLinkService;

    @GetMapping("/all")
    public ResponseEntity<List<ImageLinkResponse>> getAllImageLinks() {
        return new ResponseEntity<>(imageLinkService.getAll().stream().map(ImageLinkResponse::of).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageLinkResponse> getImageLinkById(@PathVariable Long id) {
        return new ResponseEntity<>(ImageLinkResponse.of(imageLinkService.getById(id)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        imageLinkService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
