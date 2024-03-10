package com.example.prompt.dao;

import com.example.prompt.entity.Prompt.Prompt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PromptRepository extends JpaRepository<Prompt, Integer> {

    public List<Prompt> findPromptByUserId(Integer userId);
}
