package com.etiya.workshoppair2.repository.abstracts;

import com.etiya.workshoppair2.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer > {
}
