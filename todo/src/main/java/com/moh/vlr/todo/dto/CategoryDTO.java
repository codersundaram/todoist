package com.moh.vlr.todo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
@Getter
@Setter
public class CategoryDTO {
    Long categoryId;
    @NotBlank(message = "Name value should not be empty")
    String name;

}
