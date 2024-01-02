package com.example.prompt.service.managerment;

import com.example.prompt.entity.LLMs.Prompt;

import java.util.List;

/**
 * @date 2023/12/22
 * 管理功能，用于管理已有的提示词和模型
 */
public interface ManagerService {

    /**
     * 获取用户上传的所有提示词
     * @param userId 用户的id
     */
    List<Prompt> getUserPrompts(Integer userId);
}
