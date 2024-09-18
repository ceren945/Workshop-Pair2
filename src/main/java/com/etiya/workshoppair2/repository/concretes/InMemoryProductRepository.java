package com.etiya.workshoppair2.repository.concretes;

import com.etiya.workshoppair2.entity.Product;
import com.etiya.workshoppair2.repository.abstracts.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProductRepository implements ProductRepository {
    List<Product> products = new ArrayList<Product>();

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Product getById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }

        }
        return null;
    }


    @Override
    public Product add(Product product) {
        products.add(product);
        return product;
    }

    @Override
    public Product update(Product product) {
        for (Product p : products) {
            if (product.getId() == p.getId()) {
                  p.setName(product.getName());
                  p.setId(product.getId());
                  p.setUnitPrice(product.getUnitPrice());
                  p.setUnitsInStock(product.getUnitsInStock());
                return p;
            }


        }
        return null;
    }

    @Override
    public Product delete(int id) {
        products.removeIf(product -> product.getId() == id);
        return getById(id);
    }
}
