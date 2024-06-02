package com.moh.vlr.todo.mapper;

import com.moh.vlr.todo.dto.TaskDTO;
import com.moh.vlr.todo.entity.Category;
import com.moh.vlr.todo.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface Task1Mapper {
    @Mapping(source = "user.userId", target = "userId")
    //@Mapping(source = "categories", target = "categories")
    TaskDTO toTaskDTO(Task task);

    @Mapping(target = "user.userId", source = "userId")
    @Mapping(target = "categories", ignore = true)
    Task toTask(TaskDTO taskDTO);


}
