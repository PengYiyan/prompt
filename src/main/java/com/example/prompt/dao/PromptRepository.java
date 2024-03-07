package com.example.prompt.dao;

import com.example.prompt.entity.Prompt.MiniPrompt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromptRepository extends JpaRepository<MiniPrompt, Integer> {

}
