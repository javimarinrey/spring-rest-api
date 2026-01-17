package com.example.springrestapi.dto;

import com.example.springrestapi.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Setter
@Getter
public class UserResponse {

    private Long id;
    private String name;
    private String email;
    private boolean active;
    private Instant createdAt;
    private Instant updatedAt;

    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.active = user.isActive();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
    }

    // getters
}

