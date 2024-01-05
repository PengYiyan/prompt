package com.example.prompt.service.managerment;

import com.example.prompt.entity.LLMs.Model;
import com.example.prompt.entity.LLMs.Prompt;

import java.util.List;

/**
 * @date 2023/12/22
 * 管理功能，用于管理已有的提示词和模型
 */
public interface ManagerService {

    /**
     * 获取所有的提示词
     * @return
     */
    List<Prompt> getAllPrompts();

    /**
     * 获取用户上传的所有提示词
     * @param userId 用户的id
     */
    List<Prompt> getPromptByUser(Integer userId);

    /**
     * 获取所有的大模型
     * @return
     */
    List<Model> getAllModels();

    /**
     * 获取用户上传的所有大模型
     * @param userId
     * @return
     */
    List<Model> getModelByUser(Integer userId);

    //TODO 增删改查
}
