package com.example.prompt.service.application;

import com.example.prompt.vo.ResultVO;

/**
 * @date 2023/12/22
 * 聊天框相关功能（包括智能问答）
 */
public interface QuestionService {

    /**
     * 根据提问内容返回答案
     * @param question
     * @return
     */
    ResultVO getAnswer(String question);

}
