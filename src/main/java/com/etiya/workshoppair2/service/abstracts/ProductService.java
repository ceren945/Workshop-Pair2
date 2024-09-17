package com.etiya.workshoppair2.service.abstracts;

import com.etiya.workshoppair2.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product getById(int id);
    Product add(Product product);
    Product update(Product product);
    void delete(int id);
}
