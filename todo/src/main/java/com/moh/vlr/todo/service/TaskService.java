package com.moh.vlr.todo.service;

import com.moh.vlr.todo.dto.TaskDTO;
import com.moh.vlr.todo.entity.Task;

public interface TaskService {

    TaskDTO addTask(TaskDTO request);
}
