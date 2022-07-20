package com.tom.selling.orderitem.boundary;

import com.tom.selling.orderitem.entity.OrderItemDto;
import com.tom.selling.orderitem.control.OrderItemService;
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
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/order-item/all")
    public ResponseEntity<List<OrderItemDto>> getAllOrderItems() {
        return new ResponseEntity<>(orderItemService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/order-item/{id}")
    public ResponseEntity<OrderItemDto> getOrderItemById(@PathVariable Long id) {
        return new ResponseEntity<>(orderItemService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/order-item")
    public ResponseEntity<Void> createNewOrderItem(@RequestBody(required = false) OrderItemDto orderItemDto) {
        if (orderItemDto != null) {
            orderItemService.createNew(orderItemDto);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/order-item/all")
    public ResponseEntity<Void> deleteAllOrderItems() {
        orderItemService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/order-item/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        orderItemService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/order-item")
    public ResponseEntity<Void> updateOrderItem(@RequestBody OrderItemDto updatedOrderItem) {
        orderItemService.update(updatedOrderItem);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
