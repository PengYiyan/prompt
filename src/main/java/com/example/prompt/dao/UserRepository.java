package com.example.prompt.dao;

import com.example.prompt.entity.Role.User;
import com.example.prompt.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {

    public List<User> findUserByRole(UserRole userRole);
}
