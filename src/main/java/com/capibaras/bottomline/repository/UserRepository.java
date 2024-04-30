package com.capibaras.bottomline.repository;

import com.capibaras.bottomline.models.User;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmailAndPassword(String Email, String Password);
}
