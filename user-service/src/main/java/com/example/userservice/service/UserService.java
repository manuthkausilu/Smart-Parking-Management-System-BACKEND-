package com.example.userservice.service;


import com.example.userservice.dto.Response;
import com.example.userservice.dto.UserDTO;

import java.util.List;

public interface UserService {

    Response createUser(UserDTO userDTO);

    Response getUserById(Long id);

    Response updateUser(Long id, String name, String phone);

    Response deleteUser(Long id);

    Response getAllUsers();
}
