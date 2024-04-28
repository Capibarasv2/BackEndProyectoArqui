package com.capibaras.bottomline.services;

import com.capibaras.bottomline.models.User;
import com.capibaras.bottomline.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User updateUser(User user) {
        Optional<User> existingUser = userRepository.findById(user.getId());
        if (existingUser.isPresent()) {
            User updatedUser = existingUser.get();
            updatedUser.setEmail(user.getEmail());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setRole(user.getRole());
            return userRepository.save(updatedUser);
        } else {
            throw new RuntimeException("User with ID " + user.getId() + " not found");
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Long countUsers() {
        return userRepository.count();
    }
}
