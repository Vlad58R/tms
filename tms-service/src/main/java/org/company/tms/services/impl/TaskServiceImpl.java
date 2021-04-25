package org.company.tms.services.impl;

import org.company.tms.models.Task;
import org.company.tms.repositories.TaskRepository;
import org.company.tms.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task findTaskById(Integer taskId) {
        Optional<Task> task = taskRepository.findById(taskId);
        return task.orElseThrow(() -> new RuntimeException("Task not found"));
    }

    @Override
    public List<Task> findTasks() {
        List<Task> tasks = (List<Task>) taskRepository.findAll();
        return tasks;
    }

    @Override
    public void createTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void updateTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);
    }
}
