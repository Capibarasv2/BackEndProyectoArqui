package com.capibaras.bottomline.repository;

import com.capibaras.bottomline.models.User;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmailAndPassword(String Email, String Password);

    Optional<User> findByEmailAndPassword(String email, String password);
}
