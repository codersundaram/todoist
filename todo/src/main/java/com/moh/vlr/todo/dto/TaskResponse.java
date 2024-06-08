package com.moh.vlr.todo.dto;

import com.moh.vlr.todo.entity.Category;
import com.moh.vlr.todo.entity.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class TaskResponse {

    private Long taskId;
    private String title;

    private String description;

    private String status;

    private LocalDateTime dueDate;
    private LocalDateTime completedDate;
    private UserResponse user;
    private Set<CategoryResponse> categories;

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

    public LocalDateTime getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(LocalDateTime completedDate) {
        this.completedDate = completedDate;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }

    public Set<CategoryResponse> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryResponse> categories) {
        this.categories = categories;
    }
}
