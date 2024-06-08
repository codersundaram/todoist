package com.moh.vlr.todo.dto;

public class CategoryResponse {
    private Long categoryId;
    private String name;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryResponse(Long categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }
}
