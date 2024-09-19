package com.etiya.workshoppair2.repository.concretes;

import com.etiya.workshoppair2.entity.Category;
import com.etiya.workshoppair2.entity.Product;
import com.etiya.workshoppair2.repository.abstracts.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProductRepository implements ProductRepository {
    List<Product> products = new ArrayList<Product>();

    public InMemoryProductRepository() {
        Category category = new Category();
        category.setId(1);
        category.setName("ev eşyası");
        Product product = new Product();
        product.setCategory(category);
        product.setId(12);
        product.setName("koltuk");
        products.add(product);

    }

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

    @Override
    public List<Product> getByCategory(int categoryId) {
        return products.stream().filter(product -> product.getCategory().getId()==categoryId).toList();
    }
}
