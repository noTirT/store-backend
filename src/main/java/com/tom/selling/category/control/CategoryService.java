package com.tom.selling.category.control;

import com.tom.selling.category.entity.CategoryDbo;
import com.tom.selling.category.entity.CategoryDto;
import com.tom.selling.category.entity.CategoryRequest;
import com.tom.selling.exception.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryDto> getAll() {
        return categoryRepository.findAll().stream().map(CategoryDto::of).collect(Collectors.toList());
    }

    public void createNew(CategoryRequest request) {
        categoryRepository.save(CategoryDbo.of(request));
    }
}
