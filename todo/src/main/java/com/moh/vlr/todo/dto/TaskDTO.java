package com.moh.vlr.todo.dto;

import com.moh.vlr.todo.entity.User;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
import java.util.Set;

public class TaskDTO {

    private Long taskId;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    @NotEmpty(message = "Title is mandatory")
    private String title;

    private String description;

    private String status;
    @NotNull(message = "Due date is mandatory")
    @Future(message = "Due date must be in the future")
    private LocalDateTime dueDate;

    @NotNull(message = "User is mandatory")
    @Min(value = 1, message = "User is mandatory")
    private Long userId;

    @NotNull(message = "Category is mandatory")
    @NotEmpty(message = "Category is mandatory")
    private Set<Long> categories;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Set<Long> getCategories() {
        return categories;
    }

    public void setCategories(Set<Long> categories) {
        this.categories = categories;
    }

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
