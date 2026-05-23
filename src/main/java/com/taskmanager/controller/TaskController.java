package com.taskmanager.controller;

import com.taskmanager.dto.TaskRequestDTO;
import com.taskmanager.dto.TaskResponseDTO;
import com.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskResponseDTO createTask(
            @Valid @RequestBody TaskRequestDTO taskRequestDTO
    ) {

        return taskService.createTask(taskRequestDTO);
    }

    @GetMapping
    public List<TaskResponseDTO> getAllTasks() {

        return taskService.getAllTasks();
    }


    @GetMapping("/{id}")
    public TaskResponseDTO getTaskById(
            @PathVariable Long id
    ) {

        return taskService.getTaskById(id);
    }


    @PutMapping("/{id}")
    public TaskResponseDTO updateTask(
            @Valid @RequestBody TaskRequestDTO taskRequestDTO,
            @PathVariable Long id
    ) {

        return taskService.updateTask(taskRequestDTO, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(
            @PathVariable Long id
    ) {
        taskService.deleteTask(id);
    }
}
