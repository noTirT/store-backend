package com.tom.selling.category.boundary;

import com.tom.selling.category.control.CategoryService;
import com.tom.selling.category.entity.CategoryRequest;
import com.tom.selling.category.entity.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        return new ResponseEntity<>(categoryService.getAll().stream().map(CategoryResponse::of).collect(Collectors.toList()), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Void> createNewCategory(@Valid @RequestBody CategoryRequest request) {
        categoryService.createNew(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
