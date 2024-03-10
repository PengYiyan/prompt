package com.example.prompt.service.prompt.Impl;

import com.example.prompt.Util.ConvertUtil;
import com.example.prompt.entity.Prompt.Prompt;
import com.example.prompt.enums.Mask;
import com.example.prompt.service.LLMs.ModelService;
import com.example.prompt.service.prompt.ChatService;
import com.example.prompt.vo.PromptVO;
import com.example.prompt.vo.ResponseVO;
import com.example.prompt.vo.ResultVO;
import jakarta.annotation.Resource;

import java.util.ArrayList;

public class ChatServiceImpl implements ChatService {

    @Resource
    private ModelService modelService;

    @Override
    public ResultVO getAnswer(String question,Integer userId) {
        Prompt prompt = new Prompt();
        prompt.setUserId(userId).setContent(question);
        ResultVO resultVO = new ResultVO();
        resultVO.setContent(modelService.getAnswer(prompt));
        return resultVO;
    }

    @Override
    public ResultVO getAnswerByForm(PromptVO promptVO, Integer userId) throws Exception {
        Prompt prompt = ConvertUtil.convertOne(promptVO, new Prompt());
        ResultVO resultVO = new ResultVO();
        resultVO.setContent(modelService.getAnswer(prompt));
        return resultVO;
    }

    @Override
    public ResponseVO chooseMask(Mask mask) {
//        modelService.useMask(mask);
        return ResponseVO.buildSuccess();
    }
}
