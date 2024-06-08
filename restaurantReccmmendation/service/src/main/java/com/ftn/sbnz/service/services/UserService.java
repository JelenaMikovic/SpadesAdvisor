package com.ftn.sbnz.service.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.sbnz.model.models.User;
import com.ftn.sbnz.service.dtos.UserRegistrationDTO;
import com.ftn.sbnz.service.repositories.UserRepository;
import com.ftn.sbnz.service.services.interfaces.IUserService;

@Service
public class UserService implements IUserService{
    
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(UserRegistrationDTO registrationDTO) {
        User user = new User();
        if (userRepository.findByEmail(registrationDTO.getEmail()) != null) {
            throw new IllegalArgumentException("Email already exists");
        }
        user.setFirstName(registrationDTO.getFirstName());
        user.setLastName(registrationDTO.getLastName());
        user.setEmail(registrationDTO.getEmail());
        user.setPassword(registrationDTO.getPassword());
        user.setAdmin(false);
        user.setFavoriteRestaurants(new ArrayList<>());
        user.setRecommendedRestaurants(new ArrayList<>());
        return userRepository.save(user);
    }

    @Override
    public User authenticateUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }


}
