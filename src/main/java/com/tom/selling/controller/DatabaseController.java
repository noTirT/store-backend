package com.tom.selling.controller;

import com.tom.selling.model.ArtPiece;
import com.tom.selling.model.ArtPieceLinkList;
import com.tom.selling.model.Category;
import com.tom.selling.model.Order;
import com.tom.selling.service.DataService;
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
public class DatabaseController {

    @Autowired
    private DataService dataService;

    @GetMapping("/art/all")
    public ResponseEntity<List<ArtPieceLinkList>> getAllData() {
        return new ResponseEntity<>(this.dataService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/art/id/{id}")
    public ResponseEntity<ArtPieceLinkList> getById(@PathVariable Long id) {
        return new ResponseEntity<>(ArtPieceLinkList.of(this.dataService.getById(id).orElseThrow()), HttpStatus.OK);
    }

    @PostMapping("/art")
    public ResponseEntity<Void> createNew(@RequestBody(required = false) ArtPieceLinkList artPiece) {
        if(artPiece != null) {
            this.dataService.createNew(ArtPiece.of(artPiece));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @DeleteMapping("/art/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        this.dataService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/art")
    public ResponseEntity<?> deleteAll() {
        this.dataService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/categories/all")
    public ResponseEntity<List<Category>> getAllCategories() {
        return new ResponseEntity<>(this.dataService.getAllCategories(), HttpStatus.OK);
    }

    @GetMapping("/orders/all")
    public ResponseEntity<List<Order>> getAllOrders(){
        return new ResponseEntity<>(this.dataService.getAllOrders(), HttpStatus.OK);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOderByID(@PathVariable Long id){
        return new ResponseEntity<>(this.dataService.getOrderByID(id).orElseThrow(), HttpStatus.OK);
    }

    @PostMapping("/orders")
    public ResponseEntity<Void> placeNewOrder(@RequestBody Order newOrder){
        this.dataService.placeNewOrder(newOrder);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/orders")
    public ResponseEntity<Void> updateOrder(@RequestBody Order updatedOrder){
        this.dataService.updateOrder(updatedOrder);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
