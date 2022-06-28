package com.tom.selling.controller;

import com.tom.selling.model.ArtPiece;
import com.tom.selling.model.Category;
import com.tom.selling.service.DataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
public class DatabaseController {

    @Autowired
    private DataService dataService;

    @GetMapping("/art/all")
    public ResponseEntity<List<ArtPiece>> getAllData(){
        return new ResponseEntity<>(this.dataService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/art/id/{id}")
    public ResponseEntity<ArtPiece> getById(@PathVariable Long id){
        return new ResponseEntity<>(this.dataService.getById(id).orElseThrow(), HttpStatus.OK);
    }

    @PostMapping("/admin/art")
    public ResponseEntity<Void> createNew(@RequestBody ArtPiece artPiece) {
        this.dataService.createNew(artPiece);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/categories/all")
    public ResponseEntity<List<Category>> getAllCategories(){
        return new ResponseEntity<>(this.dataService.getAllCategories(), HttpStatus.OK);
    }
}
