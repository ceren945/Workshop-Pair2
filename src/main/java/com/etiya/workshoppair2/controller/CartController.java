package com.etiya.workshoppair2.controller;

import com.etiya.workshoppair2.dto.cart.*;
import com.etiya.workshoppair2.dto.category.*;
import com.etiya.workshoppair2.service.abstracts.CartService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carts")
@RequiredArgsConstructor

public class CartController {
    @Autowired
    private final CartService cartService;

    @GetMapping("/getAll")
    public List<GetAllCartResponse> getAll() {

        return cartService.getAll();
    }

    @GetMapping("/{getById}")
    public ResponseEntity<GetByIdCartResponse> getById(@PathVariable("getById") int id) {
        if (cartService.getById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cartService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CreateCartResponse> add(@RequestBody @Valid CreateCartRequest request) {

        CreateCartResponse savedCart = cartService.add(request);
        if (savedCart != null) {
            return new ResponseEntity<>(savedCart, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete")

    public DeleteCartResponse delete(@RequestParam int id){
        return cartService.delete(id);
    }

    @PutMapping("/update")
    public UpdateCartResponse update(@RequestBody @Valid UpdateCartRequest request){
        return cartService.update(request);

    }
}
