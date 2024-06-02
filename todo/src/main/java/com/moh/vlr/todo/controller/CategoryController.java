package com.moh.vlr.todo.controller;

import com.moh.vlr.todo.dto.CategoryDTO;
import com.moh.vlr.todo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/todo/api/v1/category")
@Validated
public class CategoryController {


    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/save")
    public ResponseEntity<CategoryDTO> addCategory(@Valid @RequestBody CategoryDTO request){
        CategoryDTO response = categoryService.addCategory(request);
        return new ResponseEntity<>(response,  HttpStatus.OK);
    }

    @PutMapping("/{categoryId}/update")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Long categoryId, @Valid @RequestBody CategoryDTO request){
        CategoryDTO response = categoryService.updateCategory(categoryId, request);
        return new ResponseEntity<>(response,  HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<CategoryDTO> findCategoryByName(@PathVariable String name){
        CategoryDTO response = categoryService.findCategoryByName(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/id/{categoryId}")
    public ResponseEntity<CategoryDTO> findCategoryById(@PathVariable Long categoryId){
        CategoryDTO response = categoryService.findCategoryById(categoryId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<CategoryDTO>> findAllCategories(){
        return new ResponseEntity<>(categoryService.findAllCategories(), HttpStatus.OK);
    }

    @DeleteMapping("/id/{categoryId}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable Long categoryId){
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.noContent().build();
    }


}
