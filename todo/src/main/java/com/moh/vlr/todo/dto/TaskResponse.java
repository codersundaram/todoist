package com.moh.vlr.todo.dto;

import com.moh.vlr.todo.entity.Category;
import com.moh.vlr.todo.entity.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class TaskResponse {

    private String taskId;
    private String title;

    private String description;

    private String status;

    private LocalDateTime dueDate;
    private LocalDateTime completedDate;
    private User user;
    private Set<Category> categories;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
