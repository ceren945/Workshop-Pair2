package com.etiya.workshoppair2.controller;


import com.etiya.workshoppair2.dto.product.*;
import com.etiya.workshoppair2.entity.Product;
import com.etiya.workshoppair2.service.abstracts.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor

public class ProductController {

    private final ProductService productService;

    @GetMapping("/getAll")
    public List<GetAllProductResponse> getAll() {

        return productService.getAll();
    }

    @GetMapping("/getById")
    public ResponseEntity<GetByIdProductResponse> getById(@RequestParam int id) {
        if (productService.getById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/create")

    public ResponseEntity<CreateProductResponse> add(@RequestBody CreateProductRequest request) {

        CreateProductResponse savedProduct = productService.add(request);
        if (savedProduct != null) {
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }



    @DeleteMapping("/delete")

    public DeleteProductResponse delete(@RequestParam int id){
        return productService.delete(id);
    }

    @PutMapping("/update")
    public UpdateProductResponse update(@RequestBody UpdateProductRequest request){
        return productService.update(request);

  }

  @GetMapping
    public List<GetAllProductResponse> getAllProductsByCategoryId(@RequestParam int categoryId) {
        return productService.getByCategoryId(categoryId);
  }



}
