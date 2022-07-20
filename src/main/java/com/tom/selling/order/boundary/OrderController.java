package com.tom.selling.order.boundary;


import com.tom.selling.order.entity.OrderDto;
import com.tom.selling.order.control.OrderService;
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
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/all")
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        return new ResponseEntity<>(orderService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long id) {
        return new ResponseEntity<>(orderService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/order")
    public ResponseEntity<Void> createNewOrder(@RequestBody(required = false) OrderDto orderDto) {
        if (orderDto != null) {
            orderService.createNew(orderDto);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/order/all")
    public ResponseEntity<Void> deleteAllOrders() {
        orderService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        orderService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/order")
    public ResponseEntity<Void> updateOrder(@RequestBody OrderDto updatedOrder) {
        orderService.update(updatedOrder);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
