package com.superngb3000.pr5.repositories;

import com.superngb3000.pr5.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
    User findUserByUsernameOrEmail(String username, String email);
}
