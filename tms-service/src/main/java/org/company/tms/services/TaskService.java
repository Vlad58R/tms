package org.company.tms.services;

import org.company.tms.models.Task;

import java.util.List;

public interface TaskService {
    Task findTaskById(Integer taskId);
    List<Task> findTasks();
    void createTask(Task task);
    void updateTask(Task task);
    void deleteTask(Integer id);
}
