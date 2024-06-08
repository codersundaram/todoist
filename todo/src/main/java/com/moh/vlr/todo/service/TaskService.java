package com.moh.vlr.todo.service;

import com.moh.vlr.todo.dto.TaskDTO;
import com.moh.vlr.todo.dto.TaskResponse;
import com.moh.vlr.todo.dto.TaskUpdateDTO;
import com.moh.vlr.todo.entity.Task;

public interface TaskService {

    TaskResponse addTask(TaskDTO request);

    TaskResponse updateTask(Long taskId, TaskUpdateDTO request);
}
