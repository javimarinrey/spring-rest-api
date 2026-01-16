package com.example.springrestapi.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    // 4xx – Errores de cliente
    BAD_REQUEST(
            "BAD_REQUEST",
            HttpStatus.BAD_REQUEST,
            "Petición inválida"
    ),

    VALIDATION_ERROR(
            "VALIDATION_ERROR",
            HttpStatus.BAD_REQUEST,
            "Error de validación"
    ),

    UNAUTHORIZED(
            "UNAUTHORIZED",
            HttpStatus.UNAUTHORIZED,
            "No autenticado"
    ),

    FORBIDDEN(
            "FORBIDDEN",
            HttpStatus.FORBIDDEN,
            "Acceso denegado"
    ),

    RESOURCE_NOT_FOUND(
            "RESOURCE_NOT_FOUND",
            HttpStatus.NOT_FOUND,
            "Recurso no encontrado"
    ),

    METHOD_NOT_ALLOWED(
            "METHOD_NOT_ALLOWED",
            HttpStatus.METHOD_NOT_ALLOWED,
            "Método HTTP no permitido"
    ),

    CONFLICT(
            "CONFLICT",
            HttpStatus.CONFLICT,
            "Conflicto de estado"
    ),

    // 5xx – Errores de servidor
    INTERNAL_ERROR(
            "INTERNAL_ERROR",
            HttpStatus.INTERNAL_SERVER_ERROR,
            "Error interno del servidor"
    ),

    SERVICE_UNAVAILABLE(
            "SERVICE_UNAVAILABLE",
            HttpStatus.SERVICE_UNAVAILABLE,
            "Servicio no disponible"
    ),

    TIMEOUT(
            "TIMEOUT",
            HttpStatus.GATEWAY_TIMEOUT,
            "Tiempo de espera agotado"
    );

    private final String code;
    private final HttpStatus status;
    private final String defaultMessage;

    ErrorCode(String code, HttpStatus status, String defaultMessage) {
        this.code = code;
        this.status = status;
        this.defaultMessage = defaultMessage;
    }

    public String getCode() {
        return code;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }
}

