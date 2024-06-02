package com.moh.vlr.todo.service;

import com.moh.vlr.todo.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDTO addUser(UserDTO request);

    UserDTO updateUser(Long userId, UserDTO request);

    List<UserDTO> findAllUsers();

    void deleteUserById(Long userId);

    UserDTO findByUserId(Long userId);
}
