package com.moh.vlr.todo.controller;

import com.moh.vlr.todo.dto.UserDTO;
import com.moh.vlr.todo.entity.User;
import com.moh.vlr.todo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo/api/v1/user")
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("")
    public ResponseEntity<UserDTO> saveUser(@Valid @RequestBody UserDTO request){
        return new ResponseEntity<>(service.addUser(request), HttpStatus.OK);
    }

    @PutMapping("/id/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long userId, @Valid @RequestBody UserDTO request){
        return new ResponseEntity<>(service.updateUser(userId, request), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<UserDTO>> findAllUsers(){
        return new ResponseEntity<>(service.findAllUsers(), HttpStatus.OK);
    }

    @DeleteMapping("/id/{userId}")
    public ResponseEntity<Void> deleteUserByUserId(@PathVariable Long userId){
        service.deleteUserById(userId);
        return ResponseEntity.noContent().build();
    }
}
