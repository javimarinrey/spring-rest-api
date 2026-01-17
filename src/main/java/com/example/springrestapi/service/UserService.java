package com.example.springrestapi.service;

import com.example.springrestapi.dto.UserRequest;
import com.example.springrestapi.entity.User;
import com.example.springrestapi.exception.ApiException;
import com.example.springrestapi.exception.ErrorCode;
import com.example.springrestapi.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(UserRequest request) {
        if (repository.existsByEmail(request.getEmail())) {
            throw new ApiException(
                    ErrorCode.CONFLICT,
                    "El email ya está registrado"
            );
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());

        return repository.save(user);
    }

    public User getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ApiException(
                                ErrorCode.RESOURCE_NOT_FOUND,
                                "Usuario no encontrado"
                        ));
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public User update(Long id, UserRequest request) {
        User user = getById(id);
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        return repository.save(user);
    }

    public void delete(Long id) {
        User user = getById(id);
        repository.delete(user);
    }
}

