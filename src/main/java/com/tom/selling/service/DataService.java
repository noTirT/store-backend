package com.tom.selling.service;

import com.tom.selling.controller.ImageClient;
import com.tom.selling.model.ArtPiece;
import com.tom.selling.model.Category;
import com.tom.selling.repository.ArtRepository;
import com.tom.selling.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
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
    private ImageClient imageClient;

    @Value("${api.key}")
    private String apiKey;

    public List<ArtPiece> getAll() {
        return StreamSupport
                .stream(artRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public List<Category> getAllCategories(){
        return StreamSupport
                .stream(categoryRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Optional<ArtPiece> getById(Long id) {
        return artRepository.findById(id);
    }

    public void createNew(ArtPiece artPiece) {
        imageClient.uploadImage(apiKey, artPiece.getBase64Image());
        if(!getCategoryNames(getAllCategories()).contains(artPiece.getCategory())){
            categoryRepository.save(new Category(artPiece.getCategory()));
        }
        artRepository.save(artPiece);
    }

    private List<String> getCategoryNames(List<Category> categories){
        return categories.stream().map(Category::getCategoryname).collect(Collectors.toList());
    }
}
