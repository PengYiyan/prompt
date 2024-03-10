package com.example.prompt.service.prompt.Impl;

import com.example.prompt.dao.PromptRepository;
import com.example.prompt.entity.Prompt.Prompt;
import com.example.prompt.service.LLMs.ModelService;
import com.example.prompt.service.prompt.PromptService;
import com.example.prompt.vo.ResponseVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class PromptServiceImpl implements PromptService {

    @Resource
    private PromptRepository promptRepository;
    @Resource
    private ModelService modelService;

    @Override
    public ResponseVO insertPromptById(Integer promptId){
        Prompt prompt = promptRepository.findById(promptId).get();
        modelService.getAnswer(prompt);
        return ResponseVO.buildSuccess(promptId);
    }

    @Override
    public ResponseVO insertPrompt(String content){
        Prompt prompt = new Prompt().setContent(content);
        promptRepository.save(prompt);
//        modelService.getAnswer(prompt);
        return ResponseVO.buildSuccess();
    }

}
