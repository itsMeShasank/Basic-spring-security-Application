package com.epam.springsecuritydemo.controller;

import com.epam.springsecuritydemo.dto.UserDTO;
import com.epam.springsecuritydemo.model.User;
import com.epam.springsecuritydemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/security")
public class TestController {

    private final UserService userServiceImpl;

    @GetMapping("/welcome")
    public ResponseEntity<String> welcomeEndPoint() {
        return new ResponseEntity<>("hello world!!", HttpStatus.OK);
    }

    @GetMapping("/fetch/{name}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String name) {
        return new ResponseEntity<>(userServiceImpl.fetch(name), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userServiceImpl.saveUser(userDTO),HttpStatus.CREATED);
    }


}
