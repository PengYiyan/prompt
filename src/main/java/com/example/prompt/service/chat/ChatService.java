package com.example.prompt.service.chat;

import com.example.prompt.vo.ResultVO;

/**
 * @date 2023/12/22
 * 聊天框相关功能（包括智能问答），类似于agent的窗口
 */
public interface ChatService {

    /**
     * 根据提问内容返回答案
     * @param question
     * @return
     */
    ResultVO getAnswer(String question);

    //TODO 聊天窗一系列的消息记录导出导入等管理，类似SeecoderAI的demo

}
