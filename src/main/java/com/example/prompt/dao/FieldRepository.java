package com.example.prompt.dao;

import com.example.prompt.entity.Prompt.Field;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FieldRepository extends JpaRepository<Field, Integer> {

}
