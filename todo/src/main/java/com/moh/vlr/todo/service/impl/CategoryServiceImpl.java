package com.moh.vlr.todo.service.impl;

import com.moh.vlr.todo.dto.CategoryDTO;
import com.moh.vlr.todo.entity.Category;
import com.moh.vlr.todo.exception.AlreadyExistException;
import com.moh.vlr.todo.exception.ResourceNotFoundException;
import com.moh.vlr.todo.mapper.CategoryMapper;
import com.moh.vlr.todo.repository.CategoryRepository;
import com.moh.vlr.todo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {


    private final CategoryMapper mapper;

    private final CategoryRepository repository;
    @Autowired
    public CategoryServiceImpl(CategoryMapper mapper, CategoryRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public CategoryDTO addCategory(CategoryDTO request) {
        Category category = mapper.toEntity(request);
        Optional<Category> categoryExist = repository.findByNameIgnoreCase(category.getName());
        if(categoryExist.isPresent()){
            throw new AlreadyExistException("Category already exist: {}" + category.getName());
        }
        return mapper.toDTO(repository.save(category));
    }

    @Override
    public CategoryDTO updateCategory(Long categoryId, CategoryDTO request) {
        Category category = mapper.toEntity(request);
        Category c = repository.findByCategoryId(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found "));
        Optional<Category> categoryExist = repository.findByNameIgnoreCase(category.getName());
        if(categoryExist.isPresent()){
            throw new AlreadyExistException("Category already exist: {}" + category.getName());
        }
        c.setName(category.getName());
        return mapper.toDTO(repository.save(c));
    }

    @Override
    public CategoryDTO findCategoryByName(String name) {
        if(name.isEmpty()){
            throw new ResourceNotFoundException("Category name should not be empty or null");
        }
        Optional<Category> response = repository.findByNameIgnoreCase(name);
        if(response.isEmpty()){
            throw new ResourceNotFoundException("Category doesn't exists");
        }
        return mapper.toDTO(response.get());
    }

    @Override
    public CategoryDTO findCategoryById(Long categoryId) {
        if(categoryId == null || categoryId== 0){
            throw new ResourceNotFoundException("Category id should not be empty or null");
        }
        Optional<Category> response = repository.findByCategoryId(categoryId);
        if(response.isEmpty()){
            throw new ResourceNotFoundException("Category doesn't exists");
        }
        return mapper.toDTO(response.get());
    }

    @Override
    public List<CategoryDTO> findAllCategories() {
        List<Category> response = repository.findAll();
        return response.stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteCategory(Long categoryId) {
        repository.deleteByCategoryId(categoryId);
    }
}
