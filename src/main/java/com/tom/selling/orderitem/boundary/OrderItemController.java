package com.tom.selling.orderitem.boundary;

import com.tom.selling.orderitem.entity.OrderItemDto;
import com.tom.selling.orderitem.control.OrderItemService;
import com.tom.selling.orderitem.entity.OrderItemRequest;
import com.tom.selling.orderitem.entity.OrderItemResponse;
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
@RequestMapping("/order-item")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/all")
    public ResponseEntity<List<OrderItemResponse>> getAllOrderItems() {
        return new ResponseEntity<>(orderItemService.getAll().stream().map(OrderItemResponse::of).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItemResponse> getOrderItemById(@PathVariable Long id) {
        return new ResponseEntity<>(OrderItemResponse.of(orderItemService.getById(id)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        orderItemService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Void> updateOrderItem(@RequestBody OrderItemDto updatedOrderItem) {
        orderItemService.update(updatedOrderItem);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
