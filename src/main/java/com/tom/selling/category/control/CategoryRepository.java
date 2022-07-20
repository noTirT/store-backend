package com.tom.selling.category.control;

import com.tom.selling.category.entity.CategoryDbo;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<CategoryDbo, Long> {
}
