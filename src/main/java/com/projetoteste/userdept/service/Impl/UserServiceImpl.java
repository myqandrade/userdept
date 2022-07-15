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
import java.util.Optional;

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

    public User userDtoToUser(UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setDepartment(userDTO.getDepartment());

        return user;
    }

    @Override
    public User create(UserDTO userDTO) {
       User user = userDtoToUser(userDTO);
       return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public String delete(User user){
        userRepository.delete(user);
        return "the user has been deleted";
    }

    @Override
    public User update(User newUser, Long id){
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setDepartment(newUser.getDepartment());
                    user.setEmail(newUser.getEmail());
                    user.setId(newUser.getId());
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return userRepository.save(newUser);
                });
    }
}
