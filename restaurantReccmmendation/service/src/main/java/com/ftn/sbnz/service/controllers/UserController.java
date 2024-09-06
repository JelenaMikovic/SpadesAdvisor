package com.ftn.sbnz.service.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.ftn.sbnz.model.models.User;
import com.ftn.sbnz.service.dtos.UserInfoDTO;
import com.ftn.sbnz.service.dtos.UserLoginDTO;
import com.ftn.sbnz.service.dtos.UserRegistrationDTO;
import com.ftn.sbnz.service.services.interfaces.IUserService;

@CrossOrigin
@RestController
@RequestMapping(value = "api/users")
public class UserController {

	private IUserService userService;

	@Autowired
	public UserController(IUserService userService) {
		this.userService = userService;
	}

	@PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationDTO registrationDTO) {
        try {
            userService.registerUser(registrationDTO);
            return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

	@PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserLoginDTO loginDTO, HttpSession session) {
        User user = userService.authenticateUser(loginDTO.getEmail(), loginDTO.getPassword());
        if (user != null) {
            session.setAttribute("userId", user.getId());
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid email or password", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logoutUser(HttpSession session) {
        session.invalidate();
        return new ResponseEntity<>("Logout successful", HttpStatus.OK);
    }

    @GetMapping("/info")
    public ResponseEntity<UserInfoDTO> getUserInfo(HttpSession session) {
        UserInfoDTO userInfo = userService.userInfo((Long) session.getAttribute("userId"));
        return new ResponseEntity<>(userInfo, HttpStatus.OK);
    }

    // dodaj kontroler za update profila
    @PutMapping("/update")
    public ResponseEntity<UserInfoDTO> updateUser(UserInfoDTO userInfoDTO,HttpSession session){
        System.out.println("POGODIO GAZDA");
        System.out.println(userInfoDTO.getFirstName());
        UserInfoDTO dto = userService.updateUser(userInfoDTO, (Long) session.getAttribute("userId"));
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}