package com.moh.vlr.todo.repository;

import com.moh.vlr.todo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
