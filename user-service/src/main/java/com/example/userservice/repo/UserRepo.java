package com.example.userservice.repo;

import com.example.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);

    User findByEmail(String email);

}
