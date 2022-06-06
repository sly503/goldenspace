package com.goldenspace.service;

import com.goldenspace.dao.UserRepository;
import com.goldenspace.entity.User;
import com.goldenspace.security.requests.UserUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Optional<User> update(UserUpdateRequest user) throws Exception {
        // First get the User from DB
        Optional<User> existingUser = userRepository.findById(Long.valueOf(user.getId()));
        if (existingUser.isPresent()) {
            return userRepository.findById(Long.valueOf(user.getId()))
                    .map(userToBeUpdated -> {
                        userToBeUpdated.setPhone(user.getPhone());
                        return userRepository.save(userToBeUpdated);
                    });
        }
        return null;
    }
}
