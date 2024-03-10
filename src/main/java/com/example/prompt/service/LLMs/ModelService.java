package com.example.prompt.service.LLMs;

import com.example.prompt.entity.Prompt.Prompt;
import com.example.prompt.enums.Mask;
import com.example.prompt.vo.ResponseVO;
import com.example.prompt.vo.ResultVO;

/**
 * @date 2023/12/22
 * 大语言模型相关的操作
 * 主要是处理提示词内容并返回答案的功能
 */
public interface ModelService {

//    /**
//     * 将prompt内容输入进大模型中
//     * @param prompt
//     * @return
//     */
//    ResponseVO usePrompt(Prompt prompt);

    /**
     * 根据prompt获得大模型回答
     * @param prompt
     * @return
     */
    String getAnswer(Prompt prompt);

//    /**
//     * 载入相应的角色Mask
//     * @param mask
//     * @return
//     */
//    ResponseVO useMask(Mask mask);
    //感觉可以纯前端实现，先去掉了

}
