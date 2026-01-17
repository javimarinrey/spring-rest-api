package com.example.springrestapi.controller;

import com.example.springrestapi.dto.UserRequest;
import com.example.springrestapi.dto.UserResponse;
import com.example.springrestapi.entity.User;
import com.example.springrestapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name="User")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(@Valid @RequestBody UserRequest request) {
        return new UserResponse(service.create(request));
    }

    @GetMapping("/{id}")
    public UserResponse get(@PathVariable Long id) {
        return new UserResponse(service.getById(id));
    }

    @GetMapping
    public List<UserResponse> list() {
        return service.getAll()
                .stream()
                .map(UserResponse::new)
                .toList();
    }

    @PutMapping("/{id}")
    public UserResponse update(
            @PathVariable Long id,
            @Valid @RequestBody UserRequest request) {

        return new UserResponse(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
