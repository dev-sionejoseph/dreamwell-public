package com.devsione.dreamwell.mapper;

import com.devsione.dreamwell.dto.DreamDTO;
import com.devsione.dreamwell.entity.Dream;
import com.devsione.dreamwell.entity.User;
import com.devsione.dreamwell.service.impl.UserServiceImpl;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DreamMapper {
    private final UserServiceImpl userService;

    public DreamMapper(UserServiceImpl userService) {
        this.userService = userService;
    }

    public DreamDTO ToDTO(Dream dream){
        User dreamUser = dream.getUser();
        return DreamDTO.builder().
                id(dream.getId()).
                title(dream.getTitle()).
                description(dream.getDescription()).
                dreamDate(dream.getDreamDate()).
                userid(dreamUser.getId()).build();
    }

    public Dream ToEntity (DreamDTO dreamDTO,User dreamUser){

        return Dream.builder().
                title(dreamDTO.getTitle()).
                description(dreamDTO.getDescription()).
                dreamDate(dreamDTO.getDreamDate()).
                user(dreamUser).build();
    }


}
