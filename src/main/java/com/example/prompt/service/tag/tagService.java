package com.example.prompt.service.tag;

import com.example.prompt.entity.LLMs.Tag;
import com.example.prompt.vo.ResponseVO;

import java.util.List;

/**
 * 2024/1/4
 * 标签相关的操作
 */
public interface tagService {


    /**
     * 在某个模型内上传一个新的标签
     * @param modelId
     * @param tag
     * @return
     */
    ResponseVO uploadTag(Integer modelId,String tag);

    /**
     * 根据大语言模型生成相关tag
     * @param modelId
     * @return
     */
    List<Tag> getTagByModel(Integer modelId);
}
