package com.moh.vlr.todo.controller;

import com.moh.vlr.todo.dto.TaskDTO;
import com.moh.vlr.todo.dto.TaskResponse;
import com.moh.vlr.todo.dto.TaskUpdateDTO;
import com.moh.vlr.todo.entity.Task;
import com.moh.vlr.todo.service.TaskService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo/api/v1/task")
public class TaskController {

    private TaskService service;

    @Autowired
    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping("")
    public ResponseEntity<TaskResponse> addTask(@Valid @RequestBody TaskDTO request){
        return new ResponseEntity<>(service.addTask(request), HttpStatus.OK);
    }

    @PutMapping("/{taskId}/update")
    public ResponseEntity<TaskResponse> updateTask(@PathVariable @NotNull Long taskId, @Valid @RequestBody TaskUpdateDTO request){
        return new ResponseEntity<>(service.updateTask(taskId, request), HttpStatus.OK);
    }
}
