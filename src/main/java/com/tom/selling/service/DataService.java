package com.tom.selling.service;

import com.tom.selling.model.ArtPiece;
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
                .map(ArtPieceLinkList::of)
                .collect(Collectors.toList());
    }

    public List<Category> getAllCategories() {
        return StreamSupport
                .stream(categoryRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Optional<ArtPiece> getById(Long id) {
        return artRepository.findById(id);
    }

    public void createNew(ArtPiece artPiece) {
        Category artCategory = getCategoryById(artPiece.getCategoryid());
        if(artCategory != null) {
            if (!getCategoryNames(getAllCategories()).contains(artCategory.getCategoryname())) {
                categoryRepository.save(new Category(artCategory.getCategoryname()));
            }
        }
        artRepository.save(artPiece);
    }

    public Category getCategoryById(Long id){return categoryRepository.findById(id).orElse(null);}

    private List<String> getCategoryNames(List<Category> categories) {
        return categories.stream().map(Category::getCategoryname).collect(Collectors.toList());
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
