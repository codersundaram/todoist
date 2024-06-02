package com.moh.vlr.todo.mapper;

import com.moh.vlr.todo.dto.CategoryDTO;
import com.moh.vlr.todo.dto.UserDTO;
import com.moh.vlr.todo.entity.Category;
import com.moh.vlr.todo.entity.User;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private static final ModelMapper mapper = new ModelMapper();
    public UserDTO toDTO(User user){
        return mapper.map(user, UserDTO.class);
    }
    public User toEntity(UserDTO userDTO){
        return mapper.map(userDTO, User.class);
    }
}
