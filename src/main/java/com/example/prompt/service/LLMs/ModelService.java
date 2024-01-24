package com.example.prompt.service.LLMs;

import com.example.prompt.entity.LLMs.Prompt;
import com.example.prompt.vo.ResponseVO;
import com.example.prompt.vo.ResultVO;

/**
 * @date 2023/12/22
 * 大语言模型相关的操作
 */
public interface ModelService {

    /**
     * 将prompt内容输入进大模型中
     * @param prompt
     * @return
     */
    ResponseVO usePrompt(Prompt prompt);

    /**
     * 根据prompt获得大模型回答
     * @param prompt
     * @return
     */
    String getAnswer(Prompt prompt);

}
