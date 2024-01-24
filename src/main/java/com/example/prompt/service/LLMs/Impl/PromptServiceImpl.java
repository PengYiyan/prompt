package com.example.prompt.service.LLMs.Impl;

import com.example.prompt.dao.PromptRepository;
import com.example.prompt.entity.LLMs.Prompt;
import com.example.prompt.service.LLMs.ModelService;
import com.example.prompt.service.LLMs.PromptService;
import com.example.prompt.vo.ResponseVO;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
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
        modelService.usePrompt(prompt);
        return ResponseVO.buildSuccess(promptId);
    }

    @Override
    public ResponseVO insertPrompt(String content){
        Prompt prompt = new Prompt().setContent(content);
        promptRepository.save(prompt);
        modelService.usePrompt(prompt);
        return ResponseVO.buildSuccess();
    }

}
