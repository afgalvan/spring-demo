package com.example.demo.repositories;

import com.example.demo.models.Task;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findByPriority(Integer priority);
    List<Task> findByState(Boolean state);
}
