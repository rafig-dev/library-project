package com.example.mylibraryproject.service;

import com.example.mylibraryproject.model.UserPrincipal;
import com.example.mylibraryproject.model.entity.User;
import com.example.mylibraryproject.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findById(username).get();

        System.out.println(user.getUsername() + " logging in...");
        return new UserPrincipal(user);
    }
}
