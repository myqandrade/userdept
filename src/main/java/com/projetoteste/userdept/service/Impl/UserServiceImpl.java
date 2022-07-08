package com.projetoteste.userdept.service.Impl;

import com.projetoteste.userdept.entities.User;
import com.projetoteste.userdept.entities.UserDTO;
import com.projetoteste.userdept.repositories.UserRepository;
import com.projetoteste.userdept.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserDTO> findAll() {
        var users = userRepository.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        for(User user : users){
            var userDTO = userToUserDTO(user);
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }

    public UserDTO userToUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setDepartment(user.getDepartment());

        return userDTO;
    }

    @Override
    public User create(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO findById(Long id) {
        return null;
    }
}
