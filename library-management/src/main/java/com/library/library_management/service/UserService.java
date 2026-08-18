package com.library.library_management.service;
import java.util.List;

import org.springframework.stereotype.Service; // Fixed the import!

import com.library.library_management.model.User;
import com.library.library_management.repository.UserRepository;
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User addUser(User user){
        return userRepository.save(user);
    }
}