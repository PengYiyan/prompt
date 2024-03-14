package com.example.prompt.service.application;

import com.example.prompt.entity.Prompt.Prompt;

import java.util.List;

/**
 * @date 2023/12/16
 * 推荐模块，推荐提示词
 * 主要根据tag和收藏内容为用户推荐，类似Coin中的推荐模式
 */
public interface RecommendService {

//    /**
//     * 根据模型id获得推荐的提示词
//     * @param modelId
//     * @return
//     */
//    List<Prompt> getRecommendByModel(int modelId);
//
//    /**
//     * 根据模型类型获得推荐的提示词
//     * @param type
//     * @return
//     */
//    List<Prompt> getRecommendByType(String type);


    /**
     * 根据用户id推荐提示词(根据用户的收藏内容)
     * @param userId
     * @return
     */
    List<Prompt> getRecommendByUserId(Integer userId);



}
