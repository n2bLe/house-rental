package com.nubll.rental.service;

import com.nubll.rental.models.Role;
import com.nubll.rental.models.User;
import com.nubll.rental.repository.PropertyRepository;
import com.nubll.rental.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String register(User customUserDetails) {
        customUserDetails.setPassword(passwordEncoder.encode(customUserDetails.getPassword()));
        customUserDetails.setRole(Role.USER);
        userRepository.save(customUserDetails);
        return "Registered Successfully";
    }
}
