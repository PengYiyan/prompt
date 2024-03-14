package com.example.prompt.service.prompt.Impl;

import com.example.prompt.dao.PromptRepository;
import com.example.prompt.entity.Prompt.Field;
import com.example.prompt.entity.Prompt.Prompt;
import com.example.prompt.entity.Prompt.Tag;
import com.example.prompt.service.LLMs.ModelService;
import com.example.prompt.service.prompt.TagService;
import com.example.prompt.vo.ResponseVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Resource
    private PromptRepository promptRepository;
    @Resource
    private ModelService modelService;


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

    @Override
    public List<Tag> getTagsFromPrompt(Integer promptId) {
        Prompt prompt = promptRepository.findById(promptId).get();
        String content = prompt.getContent();
        List<Tag> tagList = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        int size = content.length();
        int i = 0;
        while(i < size){
            if (content.charAt(i)=='{'){//找到录入起点(设计中,tag用单大括号{}引用)
                while(content.charAt(i)!='}'){
                    sb.append(content.charAt(i));
                    i++;
                }
                //找到结尾之后弹出
                Tag tag = new Tag().setTagType(sb.toString());
                tagList.add(tag);
                sb.setLength(0);
            }
            i++;
        }
        return tagList;
    }

    @Override
    public List<Tag> getTagsByTag(Tag tag) {
        String content = "请列出一些" + tag.getTagType() + "类型的词汇,并用空格隔开";
        Prompt prompt = new Prompt().setContent(content);
        String answer = modelService.getAnswer(prompt);
        String[] strs = answer.split(" ");
        List<Tag> tagList = new ArrayList<>();
        for (String str : strs) {
            Tag tagNow = new Tag().setTagType(tag.getTagType()).setContent(str);
            tagList.add(tagNow);
        }
        return tagList;
    }
}
