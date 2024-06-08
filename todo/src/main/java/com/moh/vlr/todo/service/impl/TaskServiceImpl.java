package com.moh.vlr.todo.service.impl;

import com.moh.vlr.todo.dto.*;
import com.moh.vlr.todo.entity.Category;
import com.moh.vlr.todo.entity.Task;
import com.moh.vlr.todo.entity.User;
import com.moh.vlr.todo.exception.ResourceNotFoundException;
import com.moh.vlr.todo.mapper.TaskMapper;
import com.moh.vlr.todo.repository.CategoryRepository;
import com.moh.vlr.todo.repository.TaskRepository;
import com.moh.vlr.todo.repository.UserRepository;
import com.moh.vlr.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository repository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final TaskMapper mapper;

    @Autowired
    public TaskServiceImpl(TaskRepository repository, TaskMapper mapper, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public TaskResponse addTask(TaskDTO request) {
       Task task = mapper.toEntity(request);
       task.setCreatedAt(LocalDateTime.now());
        task.setUser(userRepository.findById(request.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User not found")));
        Set<Category> categories = request.getCategoryIds().stream()
                .map(categoryId -> categoryRepository.findByCategoryId(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category not found")))
                .collect(Collectors.toSet());
        task.setCategories(categories);
        repository.save(task);
        return getTaskResponse( task);
    }

    @Override
    @Transactional
    public TaskResponse updateTask(Long taskId, TaskUpdateDTO request) {
        Optional<Task> task = repository.findById(taskId);
        if(task.isEmpty()){
            throw new ResourceNotFoundException("Task does not exist");
        }
        Task res = task.get();
        res.setTitle(request.getTitle());
        res.setDescription(request.getDescription());
        res.setCompletedDate(request.getCompletedDate());
        res.setUpdatedAt(LocalDateTime.now());
        res.setStatus(request.getStatus());
        res.setUser(userRepository.findById(request.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User not found")));
        res.setCategories(request.getCategoryIds().stream()
                .map(categoryId -> categoryRepository.findByCategoryId(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category not found")))
                .collect(Collectors.toSet()));
        res = repository.save(res);
        return getTaskResponse(res);
    }

    private TaskResponse getTaskResponse( Task task) {
        Optional<User> user = userRepository.findById(task.getUser().getUserId());
        if(user.isEmpty()){
            throw new ResourceNotFoundException("User does not exist");
        }
        UserResponse userResponse = getUserResponse(user.get());
        Set<CategoryResponse> category = getCategoryResponse(task);
        TaskResponse response = new TaskResponse();
        response.setTaskId(task.getTaskId());
        response.setDescription(task.getDescription());
        response.setTitle(task.getTitle());
        response.setDueDate(task.getDueDate());
        response.setStatus(task.getStatus());
        response.setCompletedDate(task.getCompletedDate());
        response.setUser(userResponse);
        response.setCategories(category);
        return response;
    }

    private static UserResponse getUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(user.getUserId());
        userResponse.setUserName(user.getUsername());
        return userResponse;
    }

    private Set<CategoryResponse> getCategoryResponse(Task task) {
        Set<Category> categoryResponses = categoryRepository.findAllByCategoryIdIn(task.getCategories().stream()
                .map(Category::getCategoryId).collect(Collectors.toSet()));
        return categoryResponses.stream()
                .map(categoryR -> new CategoryResponse(categoryR.getCategoryId(), categoryR.getName()))
                .collect(Collectors.toSet());
    }
}
