package com.tom.selling.order.boundary;

import com.tom.selling.order.control.service.OrderService;
import com.tom.selling.order.entity.order.OrderDto;
import com.tom.selling.order.entity.order.OrderRequest;
import com.tom.selling.order.entity.order.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("")
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        return new ResponseEntity<>(orderService.getAll().stream().map(OrderResponse::of).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable Long id) {
        return new ResponseEntity<>(OrderResponse.of(orderService.getById(id)), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Void> createNewOrder(@RequestBody OrderRequest request) {
        orderService.createNew(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateOrder(@PathVariable Long id, @Valid @RequestBody OrderRequest updatedOrder) {
        orderService.update(updatedOrder, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
