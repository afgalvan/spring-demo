package com.example.demo.routes;


import com.example.demo.controllers.TaskController;
import com.example.demo.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskRouter {

    @Autowired
    TaskController taskController;

    @GetMapping
    public List<Task> getTasks() {
        return taskController.getTasks();
    }

    @PostMapping
    public Task saveTask(@RequestBody Task task) {
        return taskController.saveTask(task);
    }

    @GetMapping(path = "/{id}")
    public Task getTaskById(@PathVariable("id") Long id) {
        return taskController.getById(id);
    }

    @GetMapping(path = "/state")
    public List<Task> getTasksByState(@RequestParam("done") Boolean state) {
        return taskController.getByState(state);
    }

    @GetMapping(path = "/priority")
    public List<Task> getTaskByPriority(@RequestParam("level") Integer priority) {
        return taskController.getByPriority(priority);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteTaskById(@PathVariable("id") Long id) {
        return taskController.deleteTask(id);
    }
}
