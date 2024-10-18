package com.cst8911.auth.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApiResponse<T> {
    private int status;
    private boolean success;
    private String message;
    private T data;

    public static <T> ApiResponse<T> success( HttpStatus status, String message, T data) {
        return new ApiResponse<>(status.value(), true, message, data);
    }

    public static <T> ApiResponse<T> error( HttpStatus status, String message, T data) {
        return new ApiResponse<>(status.value(), false, message, data);
    }

}