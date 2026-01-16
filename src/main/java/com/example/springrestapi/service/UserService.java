package com.example.springrestapi.service;

import com.example.springrestapi.exception.ApiException;
import com.example.springrestapi.exception.ErrorCode;
import com.example.springrestapi.exception.ResourceNotFoundException;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User findById(Long id) {
        if (id == null) {
            throw new ApiException(ErrorCode.FORBIDDEN);
        }
        else if (id == 1) {
            throw new ApiException(
                    ErrorCode.CONFLICT,
                    "El usuario no existe"
            );
        } else {
            return null;
        }
    }
}

