package com.example.prompt.dao;

import com.example.prompt.entity.Prompt.History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History,Integer> {

    List<History> findHistoryByUserId(Integer userId);
}
