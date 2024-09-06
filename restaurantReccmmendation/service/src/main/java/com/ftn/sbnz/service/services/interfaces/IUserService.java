package com.ftn.sbnz.service.services.interfaces;

import com.ftn.sbnz.model.models.User;
import com.ftn.sbnz.service.dtos.UserInfoDTO;
import com.ftn.sbnz.service.dtos.UserRegistrationDTO;

public interface IUserService {

    User registerUser(UserRegistrationDTO registrationDTO);

    User authenticateUser(String email, String password);

    UserInfoDTO userInfo(Long userId);
    
    UserInfoDTO updateUser(UserInfoDTO updated, Long userId);
}
