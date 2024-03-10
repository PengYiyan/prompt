package com.example.prompt.service.prompt.Impl;

import com.example.prompt.Util.ConvertUtil;
import com.example.prompt.dao.HistoryRepository;
import com.example.prompt.dao.PromptRepository;
import com.example.prompt.entity.Prompt.History;
import com.example.prompt.entity.Prompt.Prompt;
import com.example.prompt.service.prompt.HistoryService;
import com.example.prompt.vo.PromptVO;
import com.example.prompt.vo.ResponseVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Resource
    private HistoryRepository historyRepository;
    @Resource
    private PromptRepository promptRepository;

    public List<Prompt> getHistoryByUserId(Integer userId){
        List<History> historyList = historyRepository.findHistoryByUserId(userId);
        List<Prompt> promptList = new ArrayList<>();
        for(History history : historyList){
            Prompt prompt = promptRepository.findById(history.getPromptId()).get();
            promptList.add(prompt);
        }
        return promptList;
    }

    public Prompt editHistory(Integer historyId, PromptVO promptVO) throws Exception {
        History history = historyRepository.findById(historyId).get();
        Prompt oriPrompt = promptRepository.findById(history.getPromptId()).get();
        //编辑提示词内容，并且将该历史记录的promptId指向新提示词
        Prompt newPrompt = ConvertUtil.convertOne(promptVO,new Prompt());
        //TODO 不知道此处的prompt是否保存了新的id，需要测试一下
        Prompt prompt = promptRepository.save(newPrompt);
        history.setPromptId(prompt.getPromptId());
        historyRepository.save(history);
        return prompt;
    }

    @Override
    public ResponseVO deleteHistory(Integer historyId) {
        historyRepository.deleteById(historyId);
        return ResponseVO.buildSuccess();
    }

    public ResponseVO useHistoryPrompt(Integer historyId){
        History history = historyRepository.findById(historyId).get();
        //TODO 调用使用提示词的Service
        return ResponseVO.buildSuccess();
    }

}
