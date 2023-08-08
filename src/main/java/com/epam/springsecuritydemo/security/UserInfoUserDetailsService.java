package com.epam.springsecuritydemo.security;

import com.epam.springsecuritydemo.dao.UserRepository;
import com.epam.springsecuritydemo.model.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;


@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserInfoUserDetailsService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user =  userRepository.findByUsername(username);
        return user.map(UserInfoUserDetails::new)
                        .orElseThrow(() -> new UsernameNotFoundException("Username provided is not found."));
    }
}
