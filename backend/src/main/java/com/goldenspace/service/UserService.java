package com.goldenspace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goldenspace.dao.UserRepository;
import com.goldenspace.entity.User;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public List<User> addUsers(List<User> users) {
        return userRepository.saveAll(users);
    }

    public void deleteUserById(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
    }

    public User updateUserById(User user) {
        return userRepository.save(user);
    }
}
