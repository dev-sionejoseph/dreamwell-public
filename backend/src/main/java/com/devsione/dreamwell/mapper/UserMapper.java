package com.devsione.dreamwell.mapper;

import com.devsione.dreamwell.dto.UserDTO;
import com.devsione.dreamwell.entity.User;
import com.devsione.dreamwell.util.BCryptUtil;

public class UserMapper {
    public static UserDTO toDTO(User user){
        if (user == null) {
            return null;
        }
        return UserDTO.builder().
                id(user.getId()).
                username(user.getUsername()).build();
    }

    public static User toEntity(UserDTO userDTO){
        if (userDTO == null) {
            return null;
        }
        String password = BCryptUtil.hashPass(userDTO.getPassword());

        return User.builder().
                username(userDTO.getUsername()).
                email(userDTO.getEmail()).
                password(password).build();

    }
}