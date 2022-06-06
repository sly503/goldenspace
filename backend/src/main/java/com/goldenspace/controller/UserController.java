package com.goldenspace.controller;

import com.goldenspace.dto.ServiceResponse;
import com.goldenspace.security.UserDetailsServiceImpl;
import com.goldenspace.security.requests.LoginRequest;
import com.goldenspace.security.requests.UserUpdateRequest;
import com.goldenspace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody UserUpdateRequest user,
                                        @RequestHeader(value = "Authorization") String jwtToken) {
        if (user == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        try {
            userService.update(user);
            return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error while updating user", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}