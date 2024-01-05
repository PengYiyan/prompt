package com.example.prompt;

import com.example.prompt.dao.UserRepository;
import com.example.prompt.entity.Role.User;
import com.example.prompt.enums.UserRole;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PromptApplicationTests {


    @Autowired
    private UserRepository userRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void selectAllUsers() {
        List<User> userList = userRepository.findAll();
        for(User user : userList){
            System.out.println(user.toString());
        }
    }

    @Test
    public void insertUser() {
        User user = new User()
                .setUserName("furina")
                .setPassword("123456")
                .setEmail("123@qq.com")
                .setRole(UserRole.STUDENT);
        userRepository.save(user);
    }

    @Test
    public void selectByRole() {
        List<User> userList = userRepository.findUserByRole(UserRole.ADMIN);
        for(User user : userList){
            System.out.println(user.toString());
        }
    }
}