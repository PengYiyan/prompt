package com.example.prompt.service.prompt;

import com.example.prompt.entity.Role.User;
import com.example.prompt.enums.Mask;
import com.example.prompt.vo.PromptVO;
import com.example.prompt.vo.ResponseVO;
import com.example.prompt.vo.ResultVO;

/**
 * @date 2023/12/22
 * 聊天框相关功能（包括智能问答），类似于agent的窗口
 */
public interface ChatService {

    //TODO 用户直接提问的内容是否和提示词算在一起？这个之后细化，先把提示词平台搭起来
    //TODO 先按照每个问题都是prompt来算吧，都计入历史记录中
    /**
     * 根据用户的提问内容返回答案
     * 直接输入句子的模式
     * @param question
     * @param userId
     * @return
     */
    ResultVO getAnswer(String question,Integer userId);

    /**
     * 用户将问题输入在提示词模板中(前端提供),直接根据模板生成prompt
     * @param promptVO
     * @param userId
     * @return
     */
    ResultVO getAnswerByForm(PromptVO promptVO, Integer userId) throws Exception;

    /**
     * 选择大模型的角色
     * @param mask
     * @return
     */
    ResponseVO chooseMask(Mask mask);

    //TODO 聊天窗一系列的消息记录导出导入等管理，类似SeecoderAI的demo



}
