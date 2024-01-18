package com.example.prompt.service.LLMs;

import com.example.prompt.vo.ResponseVO;

/**
 * @date 2023/12/22
 * 大语言模型相关的操作
 */
public interface ModelService {

    /**
     * 根据提示词id插入一条prompt
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
