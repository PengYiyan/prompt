package com.example.prompt.service.user.Impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.prompt.dao.CollectRepository;
import com.example.prompt.dao.PromptRepository;
import com.example.prompt.dao.UserRepository;
import com.example.prompt.entity.Prompt.Collect;
import com.example.prompt.entity.Prompt.Prompt;
import com.example.prompt.entity.Role.User;
import com.example.prompt.service.user.UserServcie;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserServcie {

    @Resource
    private UserRepository userRepository;
    @Resource
    private CollectRepository collectRepository;
    @Resource
    private PromptRepository promptRepository;

    @Override
    public Map<String, Object> getUserInfoMap(String token) throws RuntimeException {
        Map<String, Object> user_info;
        String auth;
        long exp;
        try {
            DecodedJWT decodedJWT = JWT.decode(token);
            exp = decodedJWT.getClaim("exp").asLong();
            auth = decodedJWT.getClaim("auth").asString();
            user_info = decodedJWT.getClaim("user_info").asMap();
        } catch (JWTDecodeException e) {
            throw new RuntimeException("error: decode token");
        }
        if (exp < System.currentTimeMillis() / 1000) {
            throw new RuntimeException("error: exp < System.currentTimeMillis()");
        }
        return user_info;
    }

    @Override
    public List<Prompt> getUserCollect(Integer userId){
//        User user = userRepository.findById(userId).get();
//        return user.getCollect();
        List<Prompt> promptList = new ArrayList<>();
        List<Collect> collectList = collectRepository.findCollectByUserId(userId);
        for (Collect collect : collectList){
            Prompt prompt = promptRepository.findById(collect.getPromptId()).get();
            promptList.add(prompt);
        }
        return promptList;
    }

}
