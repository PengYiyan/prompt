package com.example.prompt.dao;

import com.example.prompt.entity.Prompt.Collect;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollectRepository extends JpaRepository<Collect,Integer> {

    List<Collect> findCollectByUserId(Integer userId);
}
