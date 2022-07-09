package com.tom.selling.service;

import com.tom.selling.exception.CategoryNotFoundException;
import com.tom.selling.exception.ItemNotFoundException;
import com.tom.selling.model.ArtPieceDbo;
import com.tom.selling.model.ArtPieceLinkList;
import com.tom.selling.model.Category;
import com.tom.selling.model.Order;
import com.tom.selling.repository.ArtRepository;
import com.tom.selling.repository.CategoryRepository;
import com.tom.selling.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class DataService {

    @Autowired
    private ArtRepository artRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private OrderRepository orderRepository;

    public List<ArtPieceLinkList> getAll() {
        return StreamSupport
                .stream(artRepository.findAll().spliterator(), false)
                .map(artPieceDbo -> {
                    Optional<Category> categoryOptional = categoryRepository.findById(artPieceDbo.getCategoryid());
                    if (categoryOptional.isPresent())
                        return ArtPieceLinkList.of(artPieceDbo, categoryOptional.get());
                    return ArtPieceLinkList.of(artPieceDbo, null);
                })
                .collect(Collectors.toList());
    }

    public List<Category> getAllCategories() {
        return StreamSupport
                .stream(categoryRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public ArtPieceLinkList getById(Long id) {
        Optional<ArtPieceDbo> artPieceOptional = artRepository.findById(id);
        if (artPieceOptional.isPresent()) {
            Optional<Category> category = categoryRepository.findById(artPieceOptional.get().getCategoryid());
            if (category.isPresent()) {
                return ArtPieceLinkList.of(artPieceOptional.get(), category.get());
            }
            throw new CategoryNotFoundException("No category with the id " + artPieceOptional.get().getCategoryid() + " found");
        }
        throw new ItemNotFoundException("No item with the id " + id + " found");
    }

    public void createNew(ArtPieceLinkList artPiece) {
        if (!categoryRepository.existsById(artPiece.getCategory().getId())) {
            categoryRepository.save(artPiece.getCategory());
        }
        artRepository.save(ArtPieceDbo.of(artPiece));
    }


    public void deleteById(Long id) {
        this.artRepository.deleteById(id);
    }

    public void deleteAll() {
        this.artRepository.deleteAll();
    }

    public List<Order> getAllOrders() {
        return StreamSupport
                .stream(orderRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Optional<Order> getOrderByID(Long id) {
        return orderRepository.findById(id);
    }

    public void placeNewOrder(Order order) {
        this.orderRepository.save(order);
    }

    public void updateOrder(Order order) {
        this.orderRepository.save(order);
    }
}
