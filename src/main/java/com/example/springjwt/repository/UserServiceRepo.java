package com.example.springjwt.repository;

import com.example.springjwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserServiceRepo extends JpaRepository<User, Integer> {

   // Optional<User> findByEmail(String email);

    User findByEmail(String email);
}
