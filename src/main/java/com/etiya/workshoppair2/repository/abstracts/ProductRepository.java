package com.etiya.workshoppair2.repository.abstracts;

import com.etiya.workshoppair2.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
