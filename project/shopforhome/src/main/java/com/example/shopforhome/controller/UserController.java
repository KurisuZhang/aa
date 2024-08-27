package com.example.shopforhome.controller;

import com.example.shopforhome.config.JwtUtil;
import com.example.shopforhome.dto.LoginRequestDTO;
import com.example.shopforhome.dto.RegisterUserDTO;
import com.example.shopforhome.entity.User;
import com.example.shopforhome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;


    // post login
    @PostMapping("/login")
    public ResponseEntity<HashMap<String, Object>> login(@RequestBody LoginRequestDTO loginRequestDTO) {

//        Optional<User> optionalUser = userService.findByUsername(loginRequestDTO.getUsername());
//        if (optionalUser.isPresent()) {
//            User user = optionalUser.get();
//            if (loginRequestDTO.getPassword().equals(user.getPassword())) {
//                // username + role + id
//                return ResponseEntity.ok(user.getUsername()+"`"+user.getRole()+"`"+user.getId());
//            } else {
//                return ResponseEntity.status(401).body("Statue\", \"Password is Wrong\""); // Unauthorized
//            }
//        } else {
//            return ResponseEntity.status(404).body("Statue\", \"User does not exist"); // Not Found
//        }
                try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword())
            );


            Optional<User> user = userService.findByUsername(loginRequestDTO.getUsername());
            String role = user.get().getRole();
            String userName = user.get().getUsername();
            HashMap<String, Object> returnMap = new HashMap<>();
            returnMap.put("jwt", jwtUtil.generateToken(loginRequestDTO.getUsername(), role));
            returnMap.put("userName", userName);
            returnMap.put("role", role);
            return ResponseEntity.ok(returnMap);
        } catch (AuthenticationException e) {
            throw new RuntimeException("Invalid credentials");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody RegisterUserDTO registerUserDTO) {
    
        Map<String, String> hashMap = new HashMap<>();
    
        User user = new User();
        user.setUsername(registerUserDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registerUserDTO.getPassword()));
        user.setRole(registerUserDTO.getRole());
        userService.save(user);
    
        hashMap.put("status", "successful register");
        hashMap.put("userName", user.getUsername());
        hashMap.put("role", user.getRole());
    
        return ResponseEntity.ok(hashMap);
    }

    @GetMapping("/roles")
    public List<String> getDistinctRoles() {
        return userService.getDistinctRoles();
    }

}
