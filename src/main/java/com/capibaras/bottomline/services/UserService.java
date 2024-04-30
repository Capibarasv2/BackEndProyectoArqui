package com.capibaras.bottomline.services;

import com.capibaras.bottomline.dtos.UserDTO;
import com.capibaras.bottomline.models.Role;
import com.capibaras.bottomline.models.User;
import com.capibaras.bottomline.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.capibaras.bottomline.dtos.UserDTO;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final RoleService roleService;

    public UserService(UserRepository userRepository, RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }



    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(UserDTO userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        Role role = roleService.getRoleById(userDto.getRole_id())
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + userDto.getRole_id()));
        user.setRole(role);

        return userRepository.save(user);
    }

    public User updateUser(Long id, UserDTO userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        Role role = roleService.getRoleById(userDto.getRole_id())
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + userDto.getRole_id()));
        user.setRole(role);

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Long countUsers() {
        return userRepository.count();
    }

    public boolean verifyUser(String email, String password) {
        return userRepository.existsByEmailAndPassword(email, password);
    }

    /* usar UserDTO para retornar o usuário que se acabou de logar */
    public Optional<User> convertToDTO(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }


}
