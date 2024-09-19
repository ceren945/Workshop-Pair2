package com.etiya.workshoppair2.repository.abstracts;

import com.etiya.workshoppair2.entity.Category;
import com.etiya.workshoppair2.entity.Product;

import java.util.List;

public interface CategoryRepository {
    List<Category> getAll();
    Category getById(int id);
    Category add(Category category);
    Category update(Category category);
    Category delete(int id);
}
