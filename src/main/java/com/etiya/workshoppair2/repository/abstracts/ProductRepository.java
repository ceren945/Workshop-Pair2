package com.etiya.workshoppair2.repository.abstracts;

import com.etiya.workshoppair2.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAll();
    Product getById(int id);
    Product add(Product product);
    Product update(Product product);
    Product delete(int id);
    List<Product> getByCategory(int categoryId);
}
