package com.example.prompt.service.prompt.Impl;

import com.example.prompt.dao.PromptRepository;
import com.example.prompt.entity.Prompt.Field;
import com.example.prompt.entity.Prompt.Prompt;
import com.example.prompt.service.prompt.TagService;
import com.example.prompt.vo.ResponseVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Resource
    private PromptRepository promptRepository;


    @Override
    public ResponseVO uploadTag(Integer promptId, Field field) {
        Prompt prompt = promptRepository.findById(promptId).get();
        //暂时先改成只能一个Field的模式，不用List了
//        List<Field> fieldList = prompt.getFields();
//        if (!fieldList.contains(field)) {//如果是未添加过的领域，添加进去
//            fieldList.add(field);
//            prompt.setFields(fieldList);
//            promptRepository.save(prompt);
//        }
        String promptField = prompt.getField();
        prompt.setField(promptField);
        promptRepository.save(prompt);
        return ResponseVO.buildSuccess();
    }
}
