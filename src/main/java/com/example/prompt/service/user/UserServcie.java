package com.example.prompt.service.user;

import java.util.Map;

/**
 * 用户门户认证
 */
public interface UserServcie {

    Map<String, Object> getUserInfoMap(String token) ;
}
