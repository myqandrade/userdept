package com.projetoteste.userdept.service;

import com.projetoteste.userdept.entities.User;
import com.projetoteste.userdept.entities.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> findAll();

    User create(UserDTO userDTO);

    UserDTO findById(Long id);
}
