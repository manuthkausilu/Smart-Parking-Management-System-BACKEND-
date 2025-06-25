package com.example.userservice.controller;

import com.example.userservice.dto.Response;
import com.example.userservice.dto.UserDTO;
import com.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userServiceImpl;

    @PostMapping("/register")
    public ResponseEntity<Response> registerUser(@RequestBody UserDTO userDTO) {
        Response response = userServiceImpl.createUser(userDTO);
        return ResponseEntity.status(response.getStatusCode() != 0 ? response.getStatusCode() : 201).body(response);
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<Response> getUserById(@PathVariable Long id) {
        Response response = userServiceImpl.getUserById(id);
        return ResponseEntity.status(response.getStatusCode() != 0 ? response.getStatusCode() : 200).body(response);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<Response> getAllUsers() {
        Response response = userServiceImpl.getAllUsers();
        return ResponseEntity.status(response.getStatusCode() != 0 ? response.getStatusCode() : 200).body(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updateUser(@PathVariable Long id,
                                               @RequestParam(value = "name", required = false) String name,
                                               @RequestParam(value = "phone",required = false) String phone) {
        Response response = userServiceImpl.updateUser(id, name, phone);
        return ResponseEntity.status(response.getStatusCode() != 0 ? response.getStatusCode() : 200).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteUser(@PathVariable Long id) {
        Response response = userServiceImpl.deleteUser(id);
        return ResponseEntity.status(response.getStatusCode() != 0 ? response.getStatusCode() : 200).body(response);
    }
}
