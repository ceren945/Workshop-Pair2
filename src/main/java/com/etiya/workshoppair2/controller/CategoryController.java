package com.etiya.workshoppair2.controller;

import com.etiya.workshoppair2.dto.category.*;
import com.etiya.workshoppair2.dto.product.*;
import com.etiya.workshoppair2.service.abstracts.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;


    @GetMapping("/getAll")
    public List<GetAllCategoryResponse> getAll() {

        return categoryService.getAll();
    }

    @GetMapping("/{getById}")
    public ResponseEntity<GetByIdCategoryResponse> getById(@PathVariable("getById") int id) {
        if (categoryService.getById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categoryService.getById(id), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<CreateCategoryResponse> add(@RequestBody @Valid CreateCategoryRequest request) {

        CreateCategoryResponse savedCategory = categoryService.add(request);
        if (savedCategory != null) {
            return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @DeleteMapping("/delete")

    public DeleteCategoryResponse delete(@RequestParam int id){
        return categoryService.delete(id);
    }

    @PutMapping("/update")
    public UpdateCategoryResponse update(@RequestBody @Valid UpdateCategoryRequest request){
        return categoryService.update(request);

    }


}
