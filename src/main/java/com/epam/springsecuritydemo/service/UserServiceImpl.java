package com.epam.springsecuritydemo.service;

import com.epam.springsecuritydemo.dao.UserRepository;
import com.epam.springsecuritydemo.dto.UserDTO;
import com.epam.springsecuritydemo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        User user  = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(encoder.encode(userDTO.getPassword()));
        userRepository.save(user);
        return userDTO;
    }

    @Override
    public User fetch(String name) {
        return userRepository.findByUsername(name)
                .orElseThrow(() -> new RuntimeException("No data found."));
    }
}
