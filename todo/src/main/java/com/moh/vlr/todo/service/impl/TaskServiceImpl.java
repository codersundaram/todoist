package com.moh.vlr.todo.service.impl;

import com.moh.vlr.todo.dto.TaskDTO;
import com.moh.vlr.todo.dto.TaskResponse;
import com.moh.vlr.todo.entity.Category;
import com.moh.vlr.todo.entity.Task;
import com.moh.vlr.todo.exception.ResourceNotFoundException;
import com.moh.vlr.todo.mapper.Task1Mapper;
import com.moh.vlr.todo.mapper.TaskMapper;
import com.moh.vlr.todo.repository.CategoryRepository;
import com.moh.vlr.todo.repository.TaskRepository;
import com.moh.vlr.todo.repository.UserRepository;
import com.moh.vlr.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository repository;
    private UserRepository userRepository;

    private CategoryRepository categoryRepository;
    private TaskMapper mapper;
    private Task1Mapper task1Mapper;

    @Autowired
    public TaskServiceImpl(TaskRepository repository, TaskMapper mapper, UserRepository userRepository, CategoryRepository categoryRepository, Task1Mapper task1Mapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.task1Mapper = task1Mapper;
    }

    @Override
    @Transactional
    public TaskDTO addTask(TaskDTO request) {
       Task task = mapper.toEntity(request);
        task.setUser(userRepository.findById(request.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User not found")));
        Set<Category> categories = request.getCategoryIds().stream()
                .map(categoryId -> categoryRepository.findByCategoryId(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category not found")))
                .collect(Collectors.toSet());
        task.setCategories(categories);
        repository.save(task);
        TaskResponse response = new TaskResponse();
        response.setCategories(task.getCategories());
        response.setUser(task.getUser());
        response.setDescription(task.getDescription());
        response.setTitle(task.getTitle());
        response.setDueDate(task.getDueDate());
        task1Mapper.toTaskDTO(task);
        return task1Mapper.toTaskDTO(task);
    }
}
