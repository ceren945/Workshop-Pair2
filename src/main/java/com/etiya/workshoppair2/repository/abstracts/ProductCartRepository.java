package com.etiya.workshoppair2.repository.abstracts;

import com.etiya.workshoppair2.entity.ProductCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCartRepository extends JpaRepository<ProductCart,Integer> {
}
