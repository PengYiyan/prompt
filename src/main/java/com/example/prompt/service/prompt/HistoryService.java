package com.example.prompt.service.prompt;

import com.example.prompt.entity.Prompt.Prompt;
import com.example.prompt.vo.PromptVO;
import com.example.prompt.vo.ResponseVO;

import java.util.List;

/**
 * 提示词历史记录管理
 */
public interface HistoryService {

    /**
     * 根据用户id获得该用户使用的提示词记录
     * @param userId
     * @return
     */
    List<Prompt> getHistoryByUserId(Integer userId);

    /**
     * 修改一条历史记录对应的prompt
     * @param historyId
     * @param promptVO
     * @return
     */
    Prompt editHistory(Integer historyId, PromptVO promptVO) throws Exception;

    /**
     * 删除一条历史记录
     * @param historyId
     * @return
     */
    ResponseVO deleteHistory(Integer historyId);

    /**
     * 执行一条历史记录的prompt
     * @param historyId
     * @return
     */
    ResponseVO useHistoryPrompt(Integer historyId);

}
