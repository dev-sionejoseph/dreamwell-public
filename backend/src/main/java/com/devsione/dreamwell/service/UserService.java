package com.devsione.dreamwell.service;

import com.devsione.dreamwell.dto.NewPasswordDTO;
import com.devsione.dreamwell.dto.UserDTO;
import com.devsione.dreamwell.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    UserDTO findById(UUID id);

    List<UserDTO> findAll();

    UserDTO save(UserDTO userDTO);

    List<User> getRawUsers();

    User rawUserByID(UUID userID);

    void deleteUser(UUID id);

    UserDTO updateEmail(UUID id, UserDTO userDTO);

    UserDTO updatePassword(UUID id, NewPasswordDTO newPasswordDTO);
}
