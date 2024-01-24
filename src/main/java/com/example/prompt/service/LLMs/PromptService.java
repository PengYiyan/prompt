package com.example.prompt.service.LLMs;

import com.example.prompt.vo.ResponseVO;

/**
 * 提示词相关的操作
 *
 */
public interface PromptService {

    /**
     * 根据提示词id插入一条prompt(插入已有提示词or候选)
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


}
