package com.example.prompt.service.prompt;

import com.example.prompt.vo.ResponseVO;

/**
 * prompt评论相关的操作
 */
public interface CommentService {

    /**
     * 在某提示词下增加一条评论
     * @param promptId
     * @param userId
     * @param content
     * @return
     */
    ResponseVO insertComment(Integer promptId, Integer userId, String content);

    /**
     * 删除一条评论
     * @param commentId
     * @param userId
     * @return
     */
    ResponseVO deleteComment(Integer commentId, Integer userId);

//    /**
//     * 点赞一条评论
//     * @param commentId
//     * @return
//     */
//    ResponseVO likeComment(Integer commentId);
//
//    /**
//     * 取消点赞
//     * @param commentId
//     * @return
//     */
//    ResponseVO dislikeComment(Integer commentId);


}
