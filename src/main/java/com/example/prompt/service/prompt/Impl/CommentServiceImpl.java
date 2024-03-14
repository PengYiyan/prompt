package com.example.prompt.service.prompt.Impl;

import com.example.prompt.dao.CommentRepository;
import com.example.prompt.dao.UserRepository;
import com.example.prompt.entity.Prompt.Comment;
import com.example.prompt.entity.Role.User;
import com.example.prompt.enums.UserRole;
import com.example.prompt.service.prompt.CommentService;
import com.example.prompt.vo.ResponseVO;
import jakarta.annotation.Resource;

public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentRepository commentRepository;
    @Resource
    private UserRepository userRepository;

    @Override
    public ResponseVO insertComment(Integer promptId, Integer userId, String content) {
        Comment comment = new Comment();
        comment.setContent(content).setUserId(userId).setPromptId(promptId);
        commentRepository.save(comment);
        return ResponseVO.buildSuccess();
    }

    @Override
    public ResponseVO deleteComment(Integer commentId, Integer userId) {
        Comment comment = commentRepository.findById(commentId).get();
        User user = userRepository.findById(userId).get();
        //判断是否有删除权限
        if (userId.equals(comment.getUserId()) || user.getRole().equals(UserRole.ADMIN)){
            commentRepository.deleteById(commentId);
            return ResponseVO.buildSuccess();
        }else {
            return ResponseVO.buildFailure("暂无删除权限");
        }
    }
}
