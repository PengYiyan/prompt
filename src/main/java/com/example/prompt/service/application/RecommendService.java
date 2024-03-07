package com.example.prompt.service.application;

import com.example.prompt.entity.Prompt.MiniPrompt;

import java.util.List;

/**
 * @date 2023/12/16
 * 推荐模块，推荐提示词
 * 主要根据tag和收藏内容为用户推荐，类似Coin
 */
public interface RecommendService {

    /**
     * 根据模型id获得推荐的提示词
     * @param modelId
     * @return
     */
    List<MiniPrompt> getRecommendByModel(int modelId);

    /**
     * 根据模型类型获得推荐的提示词
     * @param type
     * @return
     */
    List<MiniPrompt> getRecommendByType(String type);

    /**
     * 根据用户问题内容生成相应提示词（目前最重要的功能）
     * @param content
     * @return
     */
    List<MiniPrompt> getRecommendByContent(String content);

}
