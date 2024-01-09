package com.example.prompt.dao;

import com.example.prompt.entity.LLMs.Prompt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromptRepository extends JpaRepository<Prompt, Integer> {

}
