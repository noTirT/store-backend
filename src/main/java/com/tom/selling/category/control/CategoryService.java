package com.tom.selling.category.control;

import com.tom.selling.category.entity.CategoryDto;
import com.tom.selling.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements DataService<CategoryDto> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getAll() {
        return null;
    }

    @Override
    public CategoryDto getById(Long id) {
        return null;
    }

    @Override
    public void createNew(CategoryDto newItem) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void update(CategoryDto updatedItem) {

    }
}
