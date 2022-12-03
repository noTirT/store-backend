package com.tom.selling.order.boundary;

import com.tom.selling.order.control.repository.OrderItemRepository;
import com.tom.selling.order.entity.orderitem.OrderItemDto;
import com.tom.selling.order.control.service.OrderItemService;
import com.tom.selling.order.entity.orderitem.OrderItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    private final OrderItemService service;

    @GetMapping("/{orderId}")
    public ResponseEntity<List<OrderItemResponse>> getOrderItemsByOrderId(@PathVariable Long orderId) {
        return new ResponseEntity<>(service.getOrdersByOrderId(orderId).stream().map(OrderItemResponse::of).collect(Collectors.toList()), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
