package com.tom.selling.category.boundary;

import com.tom.selling.category.entity.CategoryDto;
import com.tom.selling.category.control.CategoryService;
import com.tom.selling.category.entity.CategoryRequest;
import com.tom.selling.category.entity.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        return new ResponseEntity<>(categoryService.getAll().stream().map(CategoryResponse::of).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable Long id) {
        return new ResponseEntity<>(CategoryResponse.of(categoryService.getById(id)), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Void> createNewCategory(@RequestBody(required = false) CategoryRequest request) {
        if (request != null) {
            categoryService.createNew(request);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        categoryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Void> updateCategory(@RequestBody CategoryDto updatedCategory) {
        categoryService.update(updatedCategory);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
