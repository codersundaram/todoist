package com.moh.vlr.todo.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class TaskDTO {
    @NotBlank(message = "Title is mandatory")
    private String title;

    private String description;

    private String status;

    private LocalDateTime dueDate;

    @NotBlank(message = "User ID is mandatory")
    private Long userId;

    private Set<Long> categories;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Set<Long> getCategoryIds() {
        return categories;
    }

    public void setCategoryIds(Set<Long> categoryIds) {
        this.categories = categoryIds;
    }
}
