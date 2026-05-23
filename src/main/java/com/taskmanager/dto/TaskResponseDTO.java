package com.taskmanager.dto;

import com.taskmanager.enums.TaskStatus;
import java.time.LocalDateTime;

public record TaskResponseDTO(
        Long id,
        String title,
        String description,
        TaskStatus status,
        LocalDateTime creationDate
) {
}
