package com.TP2.service;

import com.TP2.entity.Task;
import com.TP2.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task updateTask(Long id, Task updatedTask) {
        if (taskRepository.existsById(id)) {
            updatedTask.setId(id);
            return taskRepository.save(updatedTask);
        }
        return null;
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}