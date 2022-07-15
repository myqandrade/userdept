package com.projetoteste.userdept.service;

import com.projetoteste.userdept.entities.User;
import com.projetoteste.userdept.entities.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDTO> findAll();

    User create(UserDTO userDTO);

    Optional<User> findById(Long id);

    String delete(User user);
}
