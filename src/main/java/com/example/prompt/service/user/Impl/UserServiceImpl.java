package com.example.prompt.service.user.Impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.prompt.service.user.UserServcie;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserServcie {

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
}
