package com.moh.vlr.todo.service;

import com.moh.vlr.todo.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    CategoryDTO addCategory(CategoryDTO request);

    CategoryDTO updateCategory(Long categoryId, CategoryDTO request);

    CategoryDTO findCategoryByName(String name);

    CategoryDTO findCategoryById(Long categoryId);

    List<CategoryDTO> findAllCategories();

    void deleteCategory(Long categoryId);


}
