package com.example.prompt.service.application;

import com.example.prompt.entity.LLMs.Prompt;

import java.util.List;

/**
 * @date 2023/12/16
 * 推荐模块，推荐训练提示词
 */
public interface RecommendService {

    /**
     * 根据模型id获得推荐的提示词
     * @param modelId
     * @return
     */
    List<Prompt> getRecommendByModel(int modelId);

    /**
     * 根据模型类型获得推荐的提示词
     * @param type
     * @return
     */
    List<Prompt> getRecommendByType(String type);

    /**
     * 根据用户问题内容生成相应提示词（目前最重要的功能）
     * @param content
     * @return
     */
    List<Prompt> getRecommendByContent(String content);

}
