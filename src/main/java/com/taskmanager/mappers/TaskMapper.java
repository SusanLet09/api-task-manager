package com.taskmanager.mappers;

import com.taskmanager.dto.TaskRequestDTO;
import com.taskmanager.dto.TaskResponseDTO;
import com.taskmanager.entity.Task;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskMapper implements CommonMapper<TaskRequestDTO, TaskResponseDTO, Task>{


    @Override
    public Task toEntity(TaskRequestDTO request) {
        Task newTask = new Task();

        newTask.setTitle(request.title());
        newTask.setDescription(request.description());
        newTask.setStatus(request.status());
        newTask.setCreationDate(LocalDateTime.now());

        return newTask;
    }

    @Override
    public TaskResponseDTO toResponse(Task task) {
        return new TaskResponseDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getCreationDate()
        );
    }
}
