package com.tom.selling.category.control;

import com.tom.selling.category.entity.CategoryDbo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryDbo, Long> {
    Optional<CategoryDbo> findByCategoryName(String categoryName);
}
