package com.etiya.workshoppair2.repository.concretes;


import com.etiya.workshoppair2.entity.Category;
import com.etiya.workshoppair2.entity.Product;
import com.etiya.workshoppair2.repository.abstracts.CategoryRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryCategoryRepository implements CategoryRepository {

    List<Category> categories = new ArrayList<Category>();
    @Override
    public List<Category> getAll() {
        return categories;
    }

    @Override
    public Category getById(int id) {
       Optional<Category> category = categories.stream().filter(c -> c.getId() == id).findFirst();
        return category.orElse(null);
}

    @Override
    public Category add(Category category) {
        categories.add(category);
        return category;
    }

    @Override
    public Category update(Category category) {
        for (Category c : categories) {
            if (category.getId() == c.getId()) {
                c.setName(category.getName());
                c.setId(category.getId());
                return c;
            }


        }
        return null;
    }

    @Override
    public Category delete(int id) {
        categories.removeIf(category -> category.getId() == id);
        return getById(id);
    }
}
