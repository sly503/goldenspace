package com.goldenspace.security;

import com.goldenspace.dao.UserRepository;
import com.goldenspace.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws NullPointerException  {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw  new UsernameNotFoundException("");
        }else  {
            return UserDetailsImpl.build(user);
        }

    }

}
