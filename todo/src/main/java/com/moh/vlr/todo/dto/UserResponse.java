package com.moh.vlr.todo.dto;

public class UserResponse {
    private Long userId;
    private String userName;

    public UserResponse() {

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserResponse(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
