package com.example.demo.repositories;

import com.example.demo.models.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findByPriority(Integer priority);
    List<Task> findByState(Boolean state);
}
