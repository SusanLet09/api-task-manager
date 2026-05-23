package com.taskmanager.dto;

public record ErrorResponse(
        int status,
        String message
) {
}
