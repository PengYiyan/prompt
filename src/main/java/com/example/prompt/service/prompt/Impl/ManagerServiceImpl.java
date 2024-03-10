package com.example.prompt.service.prompt.Impl;

import com.example.prompt.Util.ConvertUtil;
import com.example.prompt.dao.FieldRepository;
import com.example.prompt.dao.HistoryRepository;
import com.example.prompt.dao.ModelRepository;
import com.example.prompt.dao.PromptRepository;
import com.example.prompt.entity.LLMs.Model;
import com.example.prompt.entity.Prompt.Field;
import com.example.prompt.entity.Prompt.Prompt;
import com.example.prompt.service.prompt.HistoryService;
import com.example.prompt.service.prompt.ManagerService;
import com.example.prompt.vo.PromptVO;
import com.example.prompt.vo.ResponseVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Resource
    private FieldRepository fieldRepository;
    @Resource
    private PromptRepository promptRepository;
    @Resource
    private ModelRepository modelRepository;

    @Override
    public List<Field> getAllFields() {
        List<Field> fieldList = fieldRepository.findAll();
        return fieldList;
    }

    @Override
    public List<Prompt> getPromptByUser(Integer userId) {
        List<Prompt> promptList = promptRepository.findPromptByUserId(userId);
        return promptList;//获得用户上传的所有prompt
        //使用过的prompt在历史记录里查看(上传和使用是分开的)
    }

    @Override
    public Prompt uploadPrompt(Integer userId, PromptVO promptVO) throws Exception {
        Prompt prompt = ConvertUtil.convertOne(promptVO,new Prompt());
        prompt.setUserId(userId);//设置上传用户的id
        promptRepository.save(prompt);//记录一条新的提示词
        return prompt;
    }

    @Override
    public ResponseVO deletePromptById(Integer promptId) {
        promptRepository.deleteById(promptId);
        return ResponseVO.buildSuccess();
    }

    @Override
    public List<Model> getAllModels() {
        List<Model> modelList = modelRepository.findAll();
        return modelList;
    }

    @Override
    public ResponseVO deleteModelById(Integer modelId) {
        modelRepository.deleteById(modelId);
        return ResponseVO.buildSuccess();
    }
}
