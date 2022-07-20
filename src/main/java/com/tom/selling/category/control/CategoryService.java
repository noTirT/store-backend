package com.tom.selling.category.control;

import com.tom.selling.category.entity.CategoryDbo;
import com.tom.selling.category.entity.CategoryDto;
import com.tom.selling.DataService;
import com.tom.selling.exception.ItemNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class CategoryService implements DataService<CategoryDto> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getAll() {
        return StreamSupport.stream(categoryRepository.findAll().spliterator(), false).map(CategoryDto::of).collect(Collectors.toList());
    }

    @Override
    public CategoryDto getById(Long id) {
        return CategoryDto.of(categoryRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id)));
    }

    @Override
    public void createNew(CategoryDto newItem) {
        categoryRepository.save(CategoryDbo.of(newItem));
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        categoryRepository.deleteAll();
    }

    @Override
    public void update(CategoryDto updatedItem) {
        categoryRepository.save(CategoryDbo.of(updatedItem));
    }
}
