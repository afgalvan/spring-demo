package com.example.demo.routes;

import com.example.demo.controllers.TaskController;
import com.example.demo.models.Task;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskRouter {

    private final TaskController taskController;

    @Autowired
    public TaskRouter(TaskController taskController) {
        this.taskController = taskController;
    }

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
