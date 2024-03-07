package com.example.prompt.service.prompt;

import com.example.prompt.entity.LLMs.Model;
import com.example.prompt.entity.Prompt.Field;
import com.example.prompt.entity.Prompt.MiniPrompt;
import com.example.prompt.entity.Prompt.Prompt;
import com.example.prompt.vo.ResponseVO;

import java.util.List;

/**
 * @date 2023/12/22
 * 管理功能，用于管理已有的提示词和模型
 */
public interface ManagerService {

    /**
     * 获取所有的领域类别，用于顶部分类选择
     * @return
     */
    List<Field> getAllFields();

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

    /**
     * 删除某个提示词
     * @param promptId
     * @return
     */
    ResponseVO deletePromptById(Integer promptId);

    /**
     * 删除某个模型
     * @param modelId
     * @return
     */
    ResponseVO deleteModelById(Integer modelId);



}
