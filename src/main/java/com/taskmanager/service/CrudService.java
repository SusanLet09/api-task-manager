package com.taskmanager.service;

import java.util.List;

public interface CrudService<REQUEST, RESPONSE> {

    List<RESPONSE> getAllTasks();
    RESPONSE getTaskById(Long id);
    RESPONSE createTask(REQUEST request);
    RESPONSE updateTask(REQUEST request, Long id);
    void deleteTask(Long id);
}
