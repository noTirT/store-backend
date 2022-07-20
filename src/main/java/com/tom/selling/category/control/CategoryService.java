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

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDto> getAll() {
        return StreamSupport.stream(categoryRepository.findAll().spliterator(), false).map(CategoryDto::of).collect(Collectors.toList());
    }

    public CategoryDto getById(Long id) {
        return CategoryDto.of(categoryRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id)));
    }

    public void createNew(CategoryRequest request) {
        categoryRepository.save(CategoryDbo.of(request));
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    public void update(CategoryDto updatedItem) {
        categoryRepository.save(CategoryDbo.of(updatedItem));
    }
}
