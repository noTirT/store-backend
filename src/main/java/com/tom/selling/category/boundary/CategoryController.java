package com.tom.selling.category.boundary;

import com.tom.selling.category.entity.CategoryDto;
import com.tom.selling.category.control.CategoryService;
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
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/all")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id) {
        return new ResponseEntity<>(categoryService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/category")
    public ResponseEntity<Void> createNewCategory(@RequestBody(required = false) CategoryDto categoryDto) {
        if (categoryDto != null) {
            categoryService.createNew(categoryDto);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/category/all")
    public ResponseEntity<Void> deleteAllCategories() {
        categoryService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        categoryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/category")
    public ResponseEntity<Void> updateCategory(@RequestBody CategoryDto updatedCategory) {
        categoryService.update(updatedCategory);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
