package com.example.demo.services;

import com.example.demo.models.Task;
import com.example.demo.repositories.TaskRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks() {
        return (ArrayList<Task>) taskRepository.findAll();
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public Optional<Task> getById(Long id) {
        return taskRepository.findById(id);
    }

    public List<Task> getByPriority(Integer priority) {
        return taskRepository.findByPriority(priority);
    }

    public List<Task> getByState(Boolean state) {
        return taskRepository.findByState(state);
    }

    public Boolean deleteTask(Long id) {
        try {
            taskRepository.deleteById(id);
            return true;
        } catch (Exception error) {
            return false;
        }
    }
}
