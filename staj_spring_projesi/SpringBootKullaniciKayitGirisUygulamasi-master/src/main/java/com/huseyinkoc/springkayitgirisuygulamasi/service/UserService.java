package com.huseyinkoc.springkayitgirisuygulamasi.service;

import com.huseyinkoc.springkayitgirisuygulamasi.model.User;
import com.huseyinkoc.springkayitgirisuygulamasi.repository.RoleRepository;
import com.huseyinkoc.springkayitgirisuygulamasi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created by huseyinkoc on 14.02.2019.
 */

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void saveUser(User user) {
        user.setRoles(Arrays.asList(roleRepository.findByRole("USER")));
        user.setEnabled(true);
        userRepository.save(user);
    }
}
