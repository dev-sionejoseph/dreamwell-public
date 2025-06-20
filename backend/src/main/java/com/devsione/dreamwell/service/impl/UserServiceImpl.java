package com.devsione.dreamwell.service.impl;


import com.devsione.dreamwell.dto.NewPasswordDTO;
import com.devsione.dreamwell.dto.UserDTO;
import com.devsione.dreamwell.entity.User;
import com.devsione.dreamwell.mapper.UserMapper;
import com.devsione.dreamwell.repository.UserRepository;
import com.devsione.dreamwell.service.UserService;
import com.devsione.dreamwell.util.BCryptUtil;
import org.hibernate.sql.ast.tree.expression.Over;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> findAll(){
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO findById(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapper.toDTO(user);
    }

    @Override
    public User rawUserByID(UUID userid){
        return userRepository.findById(userid)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public UserDTO save(UserDTO userDTO){

        if(userRepository.existsByEmail(userDTO.getEmail())
                || userRepository.existsByUsername(userDTO.getUsername())){
            throw new IllegalArgumentException("Username or Email exists");
        }
        User user = userRepository.save(UserMapper.toEntity(userDTO));
        return UserMapper.toDTO(user);
    }

    @Override
    public List<User> getRawUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO updateEmail(UUID id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setEmail(userDTO.getEmail());
        userRepository.save(user);

        return UserMapper.toDTO(user);
    }

    @Override
    public UserDTO updatePassword(UUID id, NewPasswordDTO newPasswordDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        String oldpass = newPasswordDTO.getOldpass();
        String newpass = newPasswordDTO.getNewpass();

        if (BCryptUtil.hashPass(oldpass).equals(user.getPassword())) {
            user.setPassword(BCryptUtil.hashPass(newpass));
            userRepository.save(user);
            return UserMapper.toDTO(user);
        } else {
            throw new RuntimeException("Incorrect credentials entered");
        }
    }

}
