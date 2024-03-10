package com.example.prompt.service.prompt;

import com.example.prompt.entity.LLMs.Model;
import com.example.prompt.entity.Prompt.Field;
import com.example.prompt.entity.Prompt.Prompt;
import com.example.prompt.vo.PromptVO;
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
     * 获取某个用户上传的所有提示词
     * @param userId 用户的id
     */
    List<Prompt> getPromptByUser(Integer userId);

    /**
     * 用户上传一条提示词
     * 在线直接上传，提供对应的前端UI页面（得到的应该是富文本格式）
     * @param userId
     * @param promptVO
     * @return Prompt 返回刚刚生成的提示词内容
     */
    Prompt uploadPrompt(Integer userId, PromptVO promptVO) throws Exception;

    /**
     * 删除某条提示词
     * @param promptId
     * @return
     */
    ResponseVO deletePromptById(Integer promptId);









    /**
     * 获取所有部署的大模型
     * @return
     */
    List<Model> getAllModels();

//    /**
//     * 获取用户上传的所有大模型
//     * @param userId
//     * @return
//     */
//    List<Model> getModelByUser(Integer userId);

    /**
     * 删除某个模型
     * @param modelId
     * @return
     */
    ResponseVO deleteModelById(Integer modelId);



}
