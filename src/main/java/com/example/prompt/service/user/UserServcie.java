package com.example.prompt.service.user;

import com.example.prompt.entity.Prompt.Prompt;

import java.util.List;
import java.util.Map;

/**
 * 和用户相关的操作
 */
public interface UserServcie {

    /**
     * 用户门户身份认证
     * @param token
     * @return
     */
    Map<String, Object> getUserInfoMap(String token) ;

    /**
     * 获得某个用户收藏的所有Prompt
     * @param userId
     * @return
     */
    List<Prompt> getUserCollect(Integer userId);

}
