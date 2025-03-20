package com.jaya.GatherVerse.data;

import com.jaya.GatherVerse.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameAndRole(String username,String role);

    User findByUsername(String username);
}
