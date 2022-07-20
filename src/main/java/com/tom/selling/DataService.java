package com.tom.selling;

import java.util.List;

public interface DataService<T> {
    List<T> getAll();
    T getById(Long id);
    void createNew(T newItem);
    void deleteById(Long id);
    void deleteAll();
    void update(T updatedItem);
}
