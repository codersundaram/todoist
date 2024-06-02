package com.moh.vlr.todo.mapper;

import com.moh.vlr.todo.dto.TaskDTO;
import com.moh.vlr.todo.dto.UserDTO;
import com.moh.vlr.todo.entity.Task;
import com.moh.vlr.todo.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    private static final ModelMapper mapper = new ModelMapper();

    public TaskDTO toDTO(Task task){
        return mapper.map(task, TaskDTO.class);
    }

    public Task toEntity(TaskDTO taskDTO){ return mapper.map(taskDTO, Task.class);}


}
