package com.example.prompt.dao;

import com.example.prompt.entity.Prompt.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
}
