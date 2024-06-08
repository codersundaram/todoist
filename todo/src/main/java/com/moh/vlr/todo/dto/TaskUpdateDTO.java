package com.moh.vlr.todo.dto;

import com.moh.vlr.todo.entity.User;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Set;

public class TaskUpdateDTO {
    private String title;
    private String status;
    private String description;
    private LocalDateTime completedDate;
    @NotNull(message = "User is mandatory")
    @Min(value = 1, message = "User is mandatory")
    private Long userId;

    @NotNull(message = "Category is mandatory")
    @NotEmpty(message = "Category is mandatory")
    private Set<Long> categoryIds;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(LocalDateTime completedDate) {
        this.completedDate = completedDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Set<Long> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(Set<Long> categoryIds) {
        this.categoryIds = categoryIds;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
