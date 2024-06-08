package com.moh.vlr.todo.service.impl;

import com.moh.vlr.todo.dto.UserDTO;
import com.moh.vlr.todo.entity.User;
import com.moh.vlr.todo.exception.AlreadyExistException;
import com.moh.vlr.todo.exception.ResourceNotFoundException;
import com.moh.vlr.todo.mapper.UserMapper;
import com.moh.vlr.todo.repository.UserRepository;
import com.moh.vlr.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;
    private UserMapper mapper;

    @Autowired
    public UserServiceImpl(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public UserDTO addUser(UserDTO request) {
        User user = mapper.toEntity(request);
        Optional<User> isEmailExist = repository.findByEmail(request.getEmail());
        if(isEmailExist.isPresent()){
            throw new AlreadyExistException("Email Already exist. Please choose some other");
        }
        return mapper.toDTO(repository.save(user));
    }

    @Override
    @Transactional
    public UserDTO updateUser(Long userId, UserDTO request) {
        Optional<User> userExist = repository.findById(userId);
        if(userExist.isEmpty()){
            throw new ResourceNotFoundException("User doesn't exist");
        }
        Optional<User> isEmailExist = repository.findByEmail(request.getEmail());
        if(isEmailExist.isPresent() && !Objects.equals(isEmailExist.get().getUserId(), userId)){
            throw new AlreadyExistException("Email Already exist. Please choose some other");
        }
        User user = userExist.get();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setCreatedAt(LocalDateTime.now());
        return mapper.toDTO(repository.save(user));
    }

    @Override
    public List<UserDTO> findAllUsers() {
        List<User> users = repository.findAll();
        return users.stream().map(user -> mapper.toDTO(user)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteUserById(Long userId) {
        repository.deleteUserByUserId(userId);
    }

    @Override
    public UserDTO findByUserId(Long userId) {
        Optional<User> user = repository.findByUserId(userId);
        if(user.isEmpty()){
            throw new ResourceNotFoundException("User does not exist");
        }
        return mapper.toDTO(user.get());
    }
}
