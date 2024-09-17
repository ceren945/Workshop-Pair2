package com.etiya.workshoppair2.service.concretes;

import com.etiya.workshoppair2.entity.Product;
import com.etiya.workshoppair2.repository.abstracts.ProductRepository;
import com.etiya.workshoppair2.service.abstracts.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private  ProductRepository productRepository;



    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public Product getById(int id) {
        return productRepository.getById(id);
    }

    @Override
    public Product add(Product product) {
       productRepository.add(product);
       return product;
    }

    @Override
    public Product update(Product product) {
        Product updatedProduct = productRepository.update(product);
        if (updatedProduct == null) {
            throw new RuntimeException("Ürün bulunamadı");
        }
        return productRepository.update(product);
    }

    @Override
    public void delete(int id) {
      productRepository.delete(id);
    }
}
