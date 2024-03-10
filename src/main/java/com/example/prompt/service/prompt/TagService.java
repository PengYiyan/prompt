package com.example.prompt.service.prompt;

import com.example.prompt.entity.Prompt.Field;
import com.example.prompt.vo.ResponseVO;

/**
 * 2024/1/4
 * 标签相关的操作，主要是管理提示词标签
 * 包括field和promptTag
 */
public interface TagService {

    /**
     * 给prompt增加一个field
     * @param promptId
     * @param field
     * @return
     */
    ResponseVO uploadTag(Integer promptId, Field field);




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
