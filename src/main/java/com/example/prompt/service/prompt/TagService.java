package com.example.prompt.service.prompt;

import com.example.prompt.entity.Prompt.Field;
import com.example.prompt.entity.Prompt.Tag;
import com.example.prompt.vo.ResponseVO;

import java.util.List;

/**
 * 2024/1/4
 * 标签相关的操作，主要是管理提示词标签
 * 包括field和tag
 */
public interface TagService {

    /**
     * 修改prompt的field
     * @param promptId
     * @param field
     * @return
     */
    ResponseVO uploadTag(Integer promptId, Field field);

    /**
     * 根据promptId获得prompt内容并返回该Prompt中可以填空的Tag
     * @param promptId
     * @return
     */
    List<Tag> getTagsFromPrompt(Integer promptId);

    /**
     * 根据Tag返回更多对应的Tag供以选择
     * @param tag
     * @return
     */
    List<Tag> getTagsByTag(Tag tag);



//    /**
//     * 在某个模型内上传一个新的标签
//     * @param modelId
//     * @param tag
//     * @return
//     */
//    ResponseVO uploadTag(Integer modelId,String tag);
//
//    /**
//     * 根据大语言模型生成相关tag
//     * @param modelId
//     * @return
//     */
//    List<MainTag> getTagByModel(Integer modelId);
}
