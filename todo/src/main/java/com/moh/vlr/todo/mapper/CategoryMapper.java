package com.moh.vlr.todo.mapper;

import com.moh.vlr.todo.dto.CategoryDTO;
import com.moh.vlr.todo.entity.Category;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public CategoryDTO toDTO(Category category){
       return modelMapper.map(category, CategoryDTO.class);
    }

    public Category toEntity(CategoryDTO categoryDTO){
        return modelMapper.map(categoryDTO, Category.class);
    }
}
