package com.example.prompt.entity.Prompt;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 评论类，用于上传的提示词的评论区
 */
@Entity
@Data
@Table(name = "comment")
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Integer comment_id;

    @Column(name = "user_id")
    private Integer userId;//回帖人的id

    @Column(name = "content")
    private String content;//回帖内容

    @Column(name = "prompt_id")
    private Integer promptId;//主题贴的id

    @Column(name = "like_count")
    private Integer likeCount = 0;//点赞评论的数目

    @Column(name = "time")
    private String time = getTime();

    private static String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return sdf.format(date);
    }
}
