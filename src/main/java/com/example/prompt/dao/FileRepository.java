package com.example.prompt.dao;

import com.example.prompt.entity.LLMs.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Integer> {

}
