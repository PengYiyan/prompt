package com.example.prompt.dao;

import com.example.prompt.entity.LLMs.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Integer> {

}
