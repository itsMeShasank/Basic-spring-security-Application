package com.epam.springsecuritydemo.service;


import com.epam.springsecuritydemo.dto.UserDTO;
import com.epam.springsecuritydemo.model.User;

public interface UserService {

    UserDTO saveUser(UserDTO userDTO);
    User fetch(String name);
}
