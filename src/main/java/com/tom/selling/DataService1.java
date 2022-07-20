package com.tom.selling;

import com.tom.selling.exception.ItemNotFoundException;
import com.tom.selling.artpiece.entity.ArtPieceDbo;
import com.tom.selling.category.entity.CategoryDbo;
import com.tom.selling.order.entity.OrderDbo;
import com.tom.selling.artpiece.entity.ArtPieceDto;
import com.tom.selling.artpiece.control.ArtRepository;
import com.tom.selling.category.control.CategoryRepository;
import com.tom.selling.orderitem.control.OrderItemRepository;
import com.tom.selling.order.control.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class DataService1 {

    @Autowired
    private ArtRepository artRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<ArtPieceDto> getAll() {
        return StreamSupport
                .stream(artRepository.findAll().spliterator(), false)
                .map(artPieceDbo -> {
                    Optional<CategoryDbo> categoryOptional = categoryRepository.findById(artPieceDbo.getCategory().getId());
                    if (categoryOptional.isPresent())
                        return ArtPieceDto.of(artPieceDbo);
                    return ArtPieceDto.of(artPieceDbo);
                })
                .collect(Collectors.toList());
    }

    public List<CategoryDbo> getAllCategories() {
        return StreamSupport
                .stream(categoryRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public ArtPieceDto getById(Long id) {
        Optional<ArtPieceDbo> artPieceOptional = artRepository.findById(id);
        if (artPieceOptional.isPresent()) {
            Optional<CategoryDbo> category = categoryRepository.findById(artPieceOptional.get().getCategory().getId());
            if (category.isPresent()) {
                return ArtPieceDto.of(artPieceOptional.get());
            }
            return ArtPieceDto.of(artPieceOptional.get());
        }
        throw new ItemNotFoundException(id);
    }

    public void createNew(ArtPieceDto artPiece) {
        if (!categoryRepository.existsById(artPiece.getCategoryDbo().getId())) {
            categoryRepository.save(artPiece.getCategoryDbo());
        }
        artRepository.save(ArtPieceDbo.of(artPiece));
    }

    public void deleteById(Long id) {
        this.artRepository.deleteById(id);
    }

    public void deleteAll() {
        this.artRepository.deleteAll();
    }

    public List<OrderDbo> getAllOrders() {
        return StreamSupport
                .stream(orderRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Optional<OrderDbo> getOrderByID(Long id) {
        return orderRepository.findById(id);
    }

    public void placeNewOrder(OrderDbo orderDbo) {
        this.orderRepository.save(orderDbo);
    }

    public void updateOrder(OrderDbo orderDbo) {
        this.orderRepository.save(orderDbo);
    }
}
