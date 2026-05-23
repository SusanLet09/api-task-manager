package com.taskmanager.dto;

import com.taskmanager.enums.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TaskRequestDTO(

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 100,message = "Title must be between 3 and 100 characters")
    String title,

    @Size(max = 255, message = "Description cannot exceed 255 characters")
    String description,

    @NotNull(message = "Status is required")
    TaskStatus status

) {

}


