package com.taskmanager.service;

import com.taskmanager.dto.TaskRequestDTO;
import com.taskmanager.dto.TaskResponseDTO;
import com.taskmanager.entity.Task;
import com.taskmanager.repository.TaskRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public List<TaskResponseDTO> getAllTasks() {

        return taskRepository.findAll()
                .stream()
                .map(taskMapper::toResponse)
                .toList();
    }

    @Override
    public TaskResponseDTO getTaskById(Long id) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));

        return taskMapper.toResponse(task);
    }

    @Override
    public TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO) {

        log.info("Creating new task...");

        Task newTask = taskMapper.toEntity(taskRequestDTO);
        Task savedTask = taskRepository.save(newTask);

        log.info("Task {} created successfully", savedTask.getTitle());

        return taskMapper.toResponse(savedTask);
    }

    @Override
    public TaskResponseDTO updateTask(TaskRequestDTO taskRequestDTO, Long id) {

        Task task = obtenerTask(id);

        task.setTitle(taskRequestDTO.title());
        task.setDescription(taskRequestDTO.description());
        task.setStatus(taskRequestDTO.status());

        Task updatedTask = taskRepository.save(task);

        log.info("Task {} updated successfully", updatedTask.getTitle());

        return taskMapper.toResponse(updatedTask);
    }

    @Override
    public void deleteTask(Long id) {
        Task task = obtenerTask(id);

        taskRepository.delete(task);

        log.info("Task with id {} deleted successfully", id);

    }
    private Task obtenerTask(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));
    }
}