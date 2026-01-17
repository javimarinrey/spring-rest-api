package com.example.springrestapi.dto;

import com.example.springrestapi.entity.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserResponse {

    private Long id;
    private String name;
    private String email;
    private boolean active;

    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.active = user.isActive();
    }

    // getters
}

