package com.etiya.workshoppair2.controller;

import com.etiya.workshoppair2.dto.category.*;
import com.etiya.workshoppair2.dto.productCart.*;
import com.etiya.workshoppair2.service.abstracts.ProductCartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productCarts")
@RequiredArgsConstructor
public class ProductCartController {

    private final ProductCartService productCartService;

    @GetMapping("/getAll")
    public List<GetAllProductCartResponse> getAll() {

        return productCartService.getAll();
    }

    @GetMapping("/{getById}")
    public ResponseEntity<GetByIdProductCartResponse> getById(@PathVariable("getById") int id) {
        if (productCartService.getById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productCartService.getById(id), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<CreateProductCartResponse> add(@RequestBody @Valid CreateProductCartRequest request) {

        CreateProductCartResponse saved = productCartService.add(request);
        if (saved != null) {
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @DeleteMapping("/delete")

    public DeleteProductCartResponse delete(@RequestParam int id){
        return productCartService.delete(id);
    }

    @PutMapping("/update")
    public UpdateProductCartResponse update(@RequestBody @Valid UpdateProductCartRequest request){
        return productCartService.update(request);

    }

}
