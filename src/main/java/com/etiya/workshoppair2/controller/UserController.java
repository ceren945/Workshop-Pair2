package com.etiya.workshoppair2.controller;

import com.etiya.workshoppair2.dto.product.*;
import com.etiya.workshoppair2.dto.user.*;
import com.etiya.workshoppair2.service.abstracts.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor

public class UserController {
    @Autowired
    private  UserService userService;


    @GetMapping("/getAll")
    public List<GetAllUserResponse> getAll() {

        return userService.getAll();
    }

    @GetMapping("/{getById}")
    public ResponseEntity<GetByIdUserResponse> getById(@PathVariable("getById") int id) {
        if (userService.getById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }


    @PostMapping("/create")
    public CreateUserResponse add(@RequestBody @Valid CreateUserRequest request) {

        return userService.add(request);


    }


    @DeleteMapping("/delete")
    public DeleteUserResponse delete(@RequestParam int id){

        return userService.delete(id);
    }

    @PutMapping("/update")
    public UpdateUserResponse update(@RequestBody @Valid UpdateUserRequest request){
        return userService.update(request);

    }
}
