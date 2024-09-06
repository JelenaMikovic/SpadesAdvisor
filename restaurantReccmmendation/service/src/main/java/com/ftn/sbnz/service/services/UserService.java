package com.ftn.sbnz.service.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.ftn.sbnz.model.models.User;
import com.ftn.sbnz.service.dtos.UserInfoDTO;
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
        return userRepository.save(user);
    }

    @Override
    public User authenticateUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public UserInfoDTO userInfo(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            return new UserInfoDTO(
                user.get().getFirstName(),
                user.get().getLastName(),
                user.get().getEmail()
        );      
        }
        return null;
    }

    @Override
    public UserInfoDTO updateUser(UserInfoDTO updated, Long userId) {
        // TODO Auto-generated method stub
        Optional<User> find = userRepository.findById(userId);
        if (find.isPresent()){
            User user = find.get();
            user.setEmail(updated.getEmail());
            user.setLastName(updated.getLastName());
            user.setFirstName(updated.getFirstName());
            userRepository.save(user);
            return new UserInfoDTO(user.getFirstName(), user.getLastName(), user.getEmail());
        }
        return null;
    }


}
