package com.example.prompt.vo;

import com.example.prompt.entity.Prompt.Prompt;
import com.example.prompt.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户VO类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {

    private Integer userId;

    private String userName;

    private String email;

    private String password;

    private UserRole role;

    private List<Prompt> collect = new ArrayList<>();//用户收藏的大段prompt内容
}
