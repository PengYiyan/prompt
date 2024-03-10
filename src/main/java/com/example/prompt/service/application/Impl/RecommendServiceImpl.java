package com.example.prompt.service.application.Impl;

import com.example.prompt.entity.Prompt.Prompt;
import com.example.prompt.service.application.RecommendService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendServiceImpl implements RecommendService {
    @Override
    public List<Prompt> getRecommendByUserId(Integer userId) {
        return null;
    }
}
