package com.example.prompt.service.prompt;

import com.example.prompt.vo.ResponseVO;

/**
 * 提示词相关的操作
 * 主要是提示词的输入(chat)和提示词生成
 * 大模型处理提示词内容并返回答案的功能在ModelService
 */
public interface PromptService {



    /**
     * 使用一条现有的提示词
     * @param promptId
     * @return
     */
    ResponseVO insertPromptById(Integer promptId);

    /**
     * 直接插入输入的提示词，并记录在数据库中
     * @param content
     * @return
     */
    ResponseVO insertPrompt(String content);

//    /**
//     * 根据用户的问题和选择的提示词，生成最终完整的提示词，用于输入
//     * @param Question
//     * @param prompts
//     * @return
//     */
//    Prompt generateTotalPrompt(String Question,List<Prompt> prompts);
//
//
//    /**
//     * 根据用户的基础问题，生成供以选择的提示词组
//     * @param Question
//     * @return
//     */
//    List<Prompt> generatePrompts(String Question);

}
