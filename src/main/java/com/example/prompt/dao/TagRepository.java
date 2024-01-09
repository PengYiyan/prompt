package com.example.prompt.dao;

import com.example.prompt.entity.LLMs.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}
